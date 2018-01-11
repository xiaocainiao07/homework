package book.daomain;

import book.dao.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import user.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
private QueryRunner qr=new QueryRunner();
//    public Book findBybid(String bid){
//    String sql="select * from book where bid=?";
//    Connection conn= JdbcUtil.getConnection();
//    Book cart=new Book();
//    try {
//        qr.query(conn,sql,new BeanHandler<Book>(Book.class),bid);
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    try {
//        conn.close();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return cart;
//}

    public List<Book> findAll(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
        List<Book> books = null;
        try {
            books = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(Book.class)
            );
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book findBybid(String bid) {
        String sql = "select * from book where bid=?";
        Connection conn = JdbcUtil.getConnection();
        Book book = new Book();
        try {
            book = qr.query(
                    conn,
                    sql,
                    new BeanHandler<Book>(Book.class),
                    bid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> findBycid(String cid) {
        String sql = "select * from book where cid=?";
        Connection conn = JdbcUtil.getConnection();
        List<Book> books=null;
        try {
            books = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(Book.class),
                    cid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;

    }
}


//public void add(Book book){
//    String sql="insert into book value()"
//}
//
//public void add(Book book){
//   String sql="insert into book value(?,?,?,?,?)";
//    Connection conn = JdbcUtil.getConnection();
//}







