package lt.vu.rest;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
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

    @PUT
    @Path("/{bookId}")
    public Book update(@PathParam("bookId") Integer bookId, Book book) {
        Book bookEntity = em.find(Book.class, bookId);
        bookEntity.setTitle(book.getTitle());
        return bookEntity;
    }

    @POST
    @Path("/")
    public void create(Book book) {
        em.persist(book);
    }
}
