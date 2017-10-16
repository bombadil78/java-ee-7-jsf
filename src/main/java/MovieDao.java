import java.util.List;

public interface MovieDao {

    List<Movie> find(MovieQuery movieQuery);

}
