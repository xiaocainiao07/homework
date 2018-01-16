package user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import user.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr=new QueryRunner();

    public int insert(User user) throws SQLException {
        String sql="insert into user values(?,?)";
        Connection connection = C3P0Util.getConnection();

        try {
            int update = qr.update(connection, sql, user.getUsername(), user.getPassword());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return Integer.parseInt(null);
    }

    public User findByUsername(String username) throws SQLException {
        String sql="select *from user where username=?";
        Connection connection = C3P0Util.getConnection();

        try {
            User user = qr.query(connection, sql, new BeanHandler<User>(User.class), username);
        return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;

    }








}
