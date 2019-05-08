package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Bookstore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BookstoreDAO {
    @Inject
    private EntityManager em;

    public void create(Bookstore bookstore) {
        em.persist(bookstore);
    }

    public List<Bookstore> getAllBookstores() {
        return em.createNamedQuery("Bookstore.findAll", Bookstore.class).getResultList();
    }
}
