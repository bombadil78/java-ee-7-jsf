import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("movieLifecycleBean")
@SessionScoped
public class MovieLifecycleBean implements MovieLifecycleAction, Serializable {

    private static final long serialVersionUID = -801599747444861944L;

    private Movie movie;

    @PostConstruct
    public void init() {
        movie = Movie.createMovieWithGenre(1L, "m1", Genre.ACTION);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void submit() {
        System.out.println("submit() called");
    }
}
