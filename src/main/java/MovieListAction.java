import java.util.List;

public interface MovieListAction {

    String getSearchString();
    void setSearchString(String s);
    void search();

    String getBeanIdentity();

    List<Movie> getMovieList();
}
