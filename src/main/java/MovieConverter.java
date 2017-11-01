import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("movieConverter")
public class MovieConverter implements Converter {

    private static final String SEPARATOR = ";";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            throw new ConverterException("Must provide a value!");
        }

        String parts[] = value.split(SEPARATOR);

        if (parts.length != 2) {
            throw new ConverterException("Format must be movieName;orderingOfGenre");
        }

        String name = parts[0];
        int ordering = Integer.parseInt(parts[1]);
        Movie m = new Movie();
        m.setName(name);
        m.setGenre(Genre.fromOrdering(ordering));
        return m;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Movie m = (Movie) value;
        return m.getName() + SEPARATOR + m.getGenre().ordinal();
    }
}
