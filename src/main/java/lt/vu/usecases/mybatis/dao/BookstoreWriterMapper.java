package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.BookstoreWriter;
import org.apache.ibatis.annotations.Param;

public interface BookstoreWriterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOKSTORE_WRITER
     *
     * @mbg.generated Wed May 08 02:15:44 EEST 2019
     */
    int deleteByPrimaryKey(@Param("bookstoreId") Integer bookstoreId, @Param("writerId") Integer writerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOKSTORE_WRITER
     *
     * @mbg.generated Wed May 08 02:15:44 EEST 2019
     */
    int insert(BookstoreWriter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOKSTORE_WRITER
     *
     * @mbg.generated Wed May 08 02:15:44 EEST 2019
     */
    List<BookstoreWriter> selectAll();
}