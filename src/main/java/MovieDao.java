import java.util.List;

public interface MovieDao {

    List<Movie> find(MovieFilter movieFilter);

}
