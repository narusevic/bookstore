package lt.vu.rest;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookRestService {

    @Inject private EntityManager em;

    @GET
    @Path("/{bookId}")
    public Book find(@PathParam("bookId") Integer bookId) {
        return em.find(Book.class, bookId);
    }
}
