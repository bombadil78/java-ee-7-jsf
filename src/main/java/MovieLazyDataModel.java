import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieLazyDataModel extends LazyDataModel<Movie> implements Serializable {

    private static final long serialVersionUID = -801599747444861922L;

    private final List<Movie> data = new ArrayList<>();

    public MovieLazyDataModel() {
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

    @Override
    public Movie getRowData(String rowKey) {
        Long rowId = Long.valueOf(rowKey);
        return data.stream().filter(m -> m.getId().equals(rowId)).findFirst().orElse(null);
    }

    @Override
    public Object getRowKey(Movie movie) {
        return movie.getId();
    }

    @Override
    public List<Movie> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        System.out.println(String.format("load() called with first=%d, pageSize=%d", first, pageSize));
        return data.subList(first, Math.min(first + pageSize, data.size()));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }
}