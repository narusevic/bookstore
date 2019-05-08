package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.BookstoreMapper;
import lt.vu.usecases.mybatis.dao.BookstoreWriterMapper;
import lt.vu.usecases.mybatis.dao.WriterMapper;
import lt.vu.usecases.mybatis.model.Bookstore;
import lt.vu.usecases.mybatis.model.BookstoreWriter;
import lt.vu.usecases.mybatis.model.Writer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

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
    private WriterMapper writerMapper;
    @Inject
    private BookstoreMapper bookstoreMapper;
    @Inject
    private BookstoreWriterMapper bookstoreWriterMapper;

    @Transactional
    public void createBookstoreWriter() {
        bookstoreMapper.insert(bookstore);
        writerMapper.insert(writer);
        BookstoreWriter bookstoreWriter = new BookstoreWriter();
        bookstoreWriter.setBookstoreId(bookstore.getId());
        bookstoreWriter.setWriterId(writer.getId());
        bookstoreWriterMapper.insert(bookstoreWriter);
        log.info("Maybe OK...");
    }

    private void loadAllWriters() {
        writers = writerMapper.selectAll();
    }
}
