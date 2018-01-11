package book.service;

import book.dao.Book;
import book.daomain.BookDao;

import java.util.List;

public class BookService {

        private BookDao bookDao = new BookDao();
        public List<Book> findAll(){
            List<Book> books = bookDao.findAll();
            return books;
        }

        public Book findBybid(String bid) {
            Book book = bookDao.findBybid(bid);
            return book;
        }

        public List<Book> findBycid(String cid) {
            List<Book> books = bookDao.findBycid(cid);
            return books;
        }
    }

//private BookDao bookDao=new BookDao();
//
//public Book bloadSer(String book) throws Exception {
//    Book bybid = bookDao.findBybid(book);
//    if (bybid==null){
//        throw new Exception();
//    }
//return bybid;
//}





