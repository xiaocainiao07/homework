package homework.jdbcUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public static void main(String[] args) throws SQLException {
Delete("wangwu");
    }

    public static void Delete(String uname) throws SQLException {
        Connection conn= JdbcUtil.getConnection();
        PreparedStatement p=conn.prepareStatement("DELETE FROM hw_user WHERE uname=?");

        p.setString(1,uname);
        p.executeUpdate();
        p.close();
        conn.close();

        System.out.println("ok");

    }
}


