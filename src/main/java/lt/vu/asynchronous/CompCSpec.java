package lt.vu.asynchronous;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class CompCSpec extends CompC implements ICompCSpec {

    @Override
    public String getCompValue() {
        return "specialized";
    }
}
