package top.cliffside.pojo.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import top.cliffside.pojo.Book;

/**
 * @author cliffside
 * @date 2021-05-14 15:02
 */
public class BookFactory implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        Book book=new Book();
        book.setBname("JAVA");
        book.setAuthor("cliff");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }
}
