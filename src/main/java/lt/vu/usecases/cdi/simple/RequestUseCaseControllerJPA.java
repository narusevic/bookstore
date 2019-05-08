package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Bookstore;
import lt.vu.entities.Writer;
import lt.vu.usecases.cdi.dao.WriterDAO;
import lt.vu.usecases.cdi.dao.BookstoreDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Bookstore bookstore = new Bookstore();
    @Getter
    private Writer writer = new Writer();
    @Getter
    private List<Writer> writers;

    @PostConstruct
    public void init() {
        loadAllWriters();
    }

    @Inject
    private WriterDAO writerDAO;
    @Inject
    private BookstoreDAO bookstoreDAO;

    @Transactional
    public void createBookstoreWriter() {
        //writer.getBookstoreList().add(bookstore);
        //bookstore.getWriterList().add(writer);
        writerDAO.create(writer);
        bookstoreDAO.create(bookstore);
        log.info("Maybe OK...");
    }

    private void loadAllWriters() {
        writers = writerDAO.getAllWriters();
        log.info("All writers");
        log.info(writers.toString());
    }
}
