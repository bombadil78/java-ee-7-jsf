import java.util.List;

public interface MovieListAction {

    MovieLazyDataModel getLazyModel();
    List<Genre> getAllGenres();
    MovieQuery getMovieQuery();
    void updateView();
}
