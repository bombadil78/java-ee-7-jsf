import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named("context")
@ApplicationScoped
public class Context implements Serializable {

    public FacesContext getInstance() {
        return FacesContext.getCurrentInstance();
    }
}
