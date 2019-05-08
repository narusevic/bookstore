package lt.vu.usecases.ejb;

import lt.vu.entities.Bookstore;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import java.util.List;

@Stateless
public class BookstoreEjbDAO {
    @PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Bookstore bookstore) {
        em.persist(bookstore);
    }

    public List<Bookstore> getAllBookstores() {
        return em.createNamedQuery("Bookstore.findAll", Bookstore.class).getResultList();
    }
}
