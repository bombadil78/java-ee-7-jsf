import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("sessionScopedMovieListBean")
@SessionScoped
public class SessionScopedMovieListBean extends AbstractMovieListBean implements Serializable {

}
