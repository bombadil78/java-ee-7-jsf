
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Named("movieListBean")
@SessionScoped
public class MovieListBean implements MovieListAction, Serializable {

    private static final long serialVersionUID = -801599747444861921L;

    @Inject
    private Context context;
    @Inject
    private MovieService movieService;
    private MovieFilter movieFilter;
    private MovieLazyDataModel dataModel;

    @PostConstruct
    private void init() {
        movieFilter = new MovieFilter();
        movieFilter.setGenre(Genre.ACTION);
        movieFilter.setNamePattern("");

        updateModel();
    }

    @Override
    public void search() {
        updateModel();
    }

    private void updateModel() {
        System.out.println(String.format("Updating model with filter: %s", movieFilter));
        List<Movie> allMovies = movieService.findAll();
        List<Movie> filteredMovies = allMovies
                .stream()
                .filter(x ->
                        movieFilter.getGenre() == null ||
                        x.getGenre().equals(movieFilter.getGenre()))
                .filter(x ->
                        x.getName().startsWith(movieFilter.getNamePattern()))
                .collect(Collectors.toList());
        filteredMovies.sort(Comparator.comparing(Movie::getId));
        dataModel = new MovieLazyDataModel(filteredMovies);
    }

    @Override
    public MovieFilter getMovieFilter() {
        return movieFilter;
    }

    @Override
    public MovieLazyDataModel getLazyModel() {
        return dataModel;
    }

    @Override
    public List<Genre> getAllGenres() {
        return Arrays.asList(Genre.values());
    }

    @Override
    public void deleteMovie(Movie movie) {
        try {
            movieService.deleteMovie(movie);
            updateModel();
        } catch(Exception ex) {
            System.out.println("Unable to delete movie");
            context.getInstance().addMessage(
                    null,
                    new FacesMessage("Unable to delete")
            );
        }

    }
}