import java.util.List;

public interface MovieListAction {

    List<Genre> getAllGenres();
    MovieQuery getMovieQuery();
    List<Movie> getMovieList();
    void updateView();
}
