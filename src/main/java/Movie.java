import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public static Movie createMovie(Long id, String name) {
        Movie m = new Movie();
        m.setId(id);
        m.setName(name);
        m.setGenre(Genre.ACTION);
        return m;
    }

    public static Movie createMovieWithGenre(Long id, String name, Genre genre) {
        Movie m = Movie.createMovie(id, name);
        m.setGenre(genre);
        return m;
    }
}
