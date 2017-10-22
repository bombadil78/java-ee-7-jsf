import java.util.List;

public interface MovieListAction {

    MovieLazyDataModel getLazyModel();
    List<Genre> getAllGenres();

    MovieFilter getMovieFilter();
    void search();
    void deleteMovie(Movie movie);
}
