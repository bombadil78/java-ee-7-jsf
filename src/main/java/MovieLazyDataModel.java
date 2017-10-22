import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieLazyDataModel extends LazyDataModel<Movie> implements Serializable {

    private static final long serialVersionUID = -801599747444861922L;

    private final List<Movie> data = new ArrayList<>();

    public MovieLazyDataModel(List<Movie> movies) {
        data.clear();
        data.addAll(movies);

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