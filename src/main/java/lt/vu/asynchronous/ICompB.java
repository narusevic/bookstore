package lt.vu.asynchronous;

import org.apache.deltaspike.core.api.future.Futureable;
import javax.transaction.Transactional;
import java.util.concurrent.Future;

public interface ICompB {

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW) // be šios anotacijos negalėsime gauti @RescueOrAsync EntityManager
    public Future<String> asyncMethod();

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW) // be šios anotacijos negalėsime gauti @RescueOrAsync EntityManager
    public Future<String> asyncMethodSpec();


}
