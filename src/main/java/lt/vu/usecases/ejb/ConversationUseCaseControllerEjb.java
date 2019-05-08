package lt.vu.usecases.ejb;

import lombok.Getter;
import lt.vu.entities.Writer;
import lt.vu.entities.Bookstore;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
@Stateful
public class ConversationUseCaseControllerEjb implements Serializable {

    private static final String PAGE_INDEX_REDIRECT = "conversation-ejb?faces-redirect=true";

    private enum CURRENT_FORM {
        CREATE_WRITER, CREATE_BOOKSTORE, CONFIRMATION
    }

    @PersistenceContext(type = PersistenceContextType.EXTENDED, synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    @Inject
    @Getter
    private Conversation conversation;

    @Inject
    private WriterEjbDAO writerEjbDAO;
    @Inject
    private BookstoreEjbDAO bookstoreEjbDAO;

    @Getter
    private Writer writer = new Writer();
    @Getter
    private Bookstore bookstore = new Bookstore();

    private CURRENT_FORM currentForm = CURRENT_FORM.CREATE_WRITER;
    public boolean isCurrentForm(CURRENT_FORM form) {
        return currentForm == form;
    }

    /**
     * The first conversation step.
     */
    public void createWriter() {
        conversation.begin();
        currentForm = CURRENT_FORM.CREATE_BOOKSTORE;
    }

    /**
     * The second conversation step.
     */
    public void createBookstore() {
        bookstore.getWriterList().add(writer);
        writer.getBookstoreList().add(bookstore);
        currentForm = CURRENT_FORM.CONFIRMATION;
    }

    /**
     * The last conversation step.
     */
    public String ok() {
        try {
            writerEjbDAO.create(writer);
            bookstoreEjbDAO.create(bookstore);
            em.joinTransaction();
            em.flush();
            Messages.addGlobalInfo("Success!");
        } catch (OptimisticLockException ole) {
            // Other user was faster...
            Messages.addGlobalWarn("Please try again");
        } catch (PersistenceException pe) {
            // Some problems with DB - most often this is programmer's fault.
           Messages.addGlobalError("Finita la commedia...");
        }
        Faces.getFlash().setKeepMessages(true);
        conversation.end();
        return PAGE_INDEX_REDIRECT;
    }

    /**
     * The last (alternative) conversation step.
     */
    public String cancel() {
        conversation.end();
        return PAGE_INDEX_REDIRECT;
    }

    public List<Bookstore> getAllBookstores() {
        return bookstoreEjbDAO.getAllBookstores();
    }
}
