package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BookDAO {
    @Inject
    private EntityManager em;

    public void create(Book book) {
        em.persist(book);
    }
    public void updateAndFlush(Book book) {
        em.merge(book);
        em.flush();
    }

    public List<Book> getAllBooks() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public Book findById(Integer id) {
        return em.find(Book.class, id);
    }
}
