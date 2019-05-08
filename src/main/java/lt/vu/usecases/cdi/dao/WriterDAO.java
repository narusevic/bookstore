package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Writer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class WriterDAO {
    @Inject
    private EntityManager em;

    public void create(Writer writer) {
        em.persist(writer);
    }

    public List<Writer> getAllWriters() {
        return em.createNamedQuery("Writer.findAll", Writer.class).getResultList();
    }
}
