package com.uplus.ureka;

import com.uplus.ureka.book.model.dao.BookDao;
import com.uplus.ureka.book.model.dao.BookDaoImp;
import com.uplus.ureka.book.model.dto.Book;
import com.uplus.ureka.book.model.dto.PageBean;
import com.uplus.ureka.member.model.dao.MemberDao;
import com.uplus.ureka.member.model.dto.Member;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest (
            properties = {"spring.config.location=classpath:application.properties"}
)
@ComponentScan(basePackages = {"com.uplus.ureka"})
class SpringBootTestApplicationBookTests { // 얘는 생성자를 만들지 X -> 필요한 건 @Autowired 통해서
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource ds;

    @Autowired
    private BookDao bookDao;

    @Test
    public void dsTest() {
        // null인지 체크하는 단정 함수
        assertNotNull(ds);
    }

    @Test
    public void bookDaoTest() {
        assertNotNull(bookDao);
    }

    @Test
    public void bookSearchAllTest() throws Exception {
        PageBean pageBean = new PageBean("title", "git", 1);
        List<Book> bookList = bookDao.searchAll(pageBean);
        assertNotNull(bookList);
        log.debug("book list: {}", bookList);
    }

    @Test
    public void bookTotalCountTest() throws Exception {
        PageBean pageBean = new PageBean("title", "백엔드", 1);
        int count = bookDao.totalCount(pageBean);
        log.debug("book count: {}", count);
    }

    @Test
    public void bookSearchTest() throws Exception {
        Book book = bookDao.search("90999");
        assertNotNull(book);
        log.debug("book: {}", book);
    }

    @Test
    public void bookRemoveTest() throws Exception {
        bookDao.remove("9999");
        log.debug("제거되었습니다.");
    }

    @Test
    public void bookUpdateTest() throws Exception {
        Book book = bookDao.search("90999");

        book.setPrice(14000);

        log.debug("업데이트된 book: {}", book);
    }

    @Test
    public void bookInsertTest() throws Exception {
        Book book = new Book();
        book.setAuthor("lsh");
        book.setIsbn("90999");
        book.setPrice(13500);
        book.setTitle("git 어려워요");

        bookDao.insert(book);

        assertNotNull(bookDao.search("9999"));
    }

}
