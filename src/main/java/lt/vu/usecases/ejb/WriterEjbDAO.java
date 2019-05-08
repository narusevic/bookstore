package lt.vu.usecases.ejb;

import lt.vu.entities.Writer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;

@Stateless
public class WriterEjbDAO {
    @PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Writer writer) {
        em.persist(writer);
    }
}
