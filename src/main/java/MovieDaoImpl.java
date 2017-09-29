import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@SessionScoped
public class MovieDaoImpl implements MovieDao, Serializable {

    @Override
    public List<Movie> findAll() {
        return Arrays.asList(new Movie(1, "A"), new Movie(2, "B"));
    }
}
