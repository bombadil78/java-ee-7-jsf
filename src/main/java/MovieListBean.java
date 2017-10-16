
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named("movieListBean")
@SessionScoped
public class MovieListBean implements MovieListAction, Serializable {

    private static final long serialVersionUID = -801599747444861921L;

    @Inject
    private MovieDao movieDao;
    private List<Genre> allGenres = new ArrayList<>();
    private MovieQuery movieQuery;
    private MovieLazyDataModel dataModel;

    @PostConstruct
    private void init() {
        movieQuery = new MovieQuery();
        movieQuery.setGenre(Genre.ACTION);
        movieQuery.setNamePattern("");
        allGenres.addAll(Arrays.asList(Genre.values()));

        dataModel = new MovieLazyDataModel();
    }

    private void search() {
        System.out.println("search() called");
    }

    @Override
    public MovieLazyDataModel getLazyModel() {
        return dataModel;
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
    public List<Genre> getAllGenres() {
        return allGenres;
    }
}