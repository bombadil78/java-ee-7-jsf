import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class MovieDaoImpl implements MovieDao, Serializable {

    private List<Movie> movies = new ArrayList<>();

    @PostConstruct
    private void init() {
        for (int i = 1; i <= 1000; i++) {
            Movie m = new Movie();
            m.setId(new Long(i));
            m.setName("m" + i);
            m.setGenre(Genre.fromOrdering(i % 4));
            movies.add(m);
        }
    }

    @Override
    public List<Movie> find(MovieQuery movieQuery) {
        return movies
                .stream()
                .filter(x -> x.getName() != null && x.getName().startsWith(movieQuery.getNamePattern()))
                .filter(x -> x.getGenre() != null && x.getGenre().equals(movieQuery.getGenre()))
                .collect(Collectors.toList());
    }
}
