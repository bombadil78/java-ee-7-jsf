import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMovieListBean implements MovieListAction {

    @Inject
    private MovieDao movieDao;
    private String searchString;
    private List<Movie> movieList;

    @Override
    public void search() {
        movieList = movieDao.findAll().stream()
                .filter(m -> m.getName().startsWith(searchString))
                .collect(Collectors.toList());
    }

    @Override
    public String getBeanIdentity() {
        return String.valueOf(hashCode());
    }

    @Override
    public String getSearchString() {
        return searchString;
    }

    @Override
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public List<Movie> getMovieList() {
        return this.movieList;
    }
}
