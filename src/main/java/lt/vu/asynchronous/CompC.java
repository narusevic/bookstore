package lt.vu.asynchronous;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.transaction.Transactional;
import java.util.concurrent.Future;

@ApplicationScoped
public class CompC {

    public String getCompValue() {
        return "parent - not specialized";
    }
}
