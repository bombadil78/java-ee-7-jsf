import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("movieValidator")
public class MovieValidator implements Validator {

    @Override
    public void validate(
            FacesContext context,
            UIComponent component,
            Object value
    ) throws ValidatorException {
        Movie movie = (Movie) value;

        if (movie.getName().matches("m*")) {
            throw new ValidatorException(new FacesMessage("Name validation failed", "Movies must start with 'm'"));
        }
    }
}
