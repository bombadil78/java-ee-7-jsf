import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("movieDetailBean")
@SessionScoped
public class MovieDetailBean implements MovieDetailAction, Serializable {

    private static final long serialVersionUID = -801599747444861923L;

    private Long selectedId;
    private Movie selectedMovie;
    private Movie movieFromString;

    @PostConstruct
    public void init() {
        this.selectedMovie = movieService.findById(1L);
    }

    @Inject
    private MovieService movieService;

    public void preRenderView() {
        System.out.println("preRenderView() called");
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        Movie found = movieService.findAll().stream().filter(x -> x.getId().equals(selectedId)).findFirst().orElse(null);
        this.selectedMovie = found;
    }

    public void setSelectedMovie(Movie movie) {
        selectedMovie = movie;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public Movie getMovieFromString() {
        return movieFromString;
    }

    public void setMovieFromString(Movie movieFromString) {
        this.movieFromString = movieFromString;
    }

    public List<Genre> getAllGenres() {
        return Arrays.asList(Genre.values());
    }

    public String submit() {
        System.out.println("submit() called");
        return "success";
    }
}