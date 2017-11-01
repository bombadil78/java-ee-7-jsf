import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Named("movieService")
@ApplicationScoped
public class MovieService implements Serializable {

    private static List<Movie> data = new ArrayList<>();

    static {
        Movie m1 = new Movie();
        m1.setId(1L);
        m1.setName("m1");
        m1.setGenre(Genre.ACTION);

        Movie m2 = new Movie();
        m2.setId(2L);
        m2.setName("m2");
        m2.setGenre(Genre.HORROR);

        Movie m3 = new Movie();
        m3.setId(3L);
        m3.setName("m3");
        m3.setGenre(Genre.COMEDY);

        data.add(m1);
        data.add(m2);
        data.add(m3);
    }

    public Movie findById(Long id) {
        return data.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Movie> findAll() {
        return data;
    }

    public void deleteMovie(Movie movie) {
        data.remove(movie);
    }

    public void addMovie(Movie movie) {
        data.add(movie);
        data.sort(Comparator.comparing(Movie::getId));
    }
}