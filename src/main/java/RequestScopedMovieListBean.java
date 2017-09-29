import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("requestScopedMovieListBean")
@RequestScoped
public class RequestScopedMovieListBean extends AbstractMovieListBean {

}
