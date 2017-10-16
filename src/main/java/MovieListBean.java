
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Named("movieListBean")
@SessionScoped
public class MovieListBean implements MovieListAction, Serializable {

    private static final long serialVersionUID = -801599747444861921L;

    @Inject
    private MovieDao movieDao;
    private List<Genre> allGenres = new ArrayList<>();
    private MovieQuery movieQuery;
    private List<Movie> movieList = new ArrayList<>();

    @PostConstruct
    private void init() {
        movieQuery = new MovieQuery();
        movieQuery.setGenre(Genre.ACTION);
        movieQuery.setNamePattern("");
        allGenres.addAll(Arrays.asList(Genre.values()));
        search();
    }

    private void search() {
        movieList = movieDao.find(movieQuery)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updateView() {
        this.search();
    }

    @Override
    public MovieQuery getMovieQuery() {
        return movieQuery;
    }

    @Override
    public List<Movie> getMovieList() {
        return this.movieList;
    }

    @Override
    public List<Genre> getAllGenres() {
        return allGenres;
    }
}