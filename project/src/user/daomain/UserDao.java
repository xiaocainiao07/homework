package user.daomain;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import user.dao.User;
import user.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class UserDao {
    private QueryRunner qr=new QueryRunner();

    public User findByUsername(String username){
        String sql="select * from user where username=?";
        Connection conn= JdbcUtil.getConnection();
        User user=new User();

        try {
            user=qr.query(conn,sql,new BeanHandler<User>(User.class),username);
            System.out.println("---"+user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private String Uuid(){
        UUID uuid=UUID.randomUUID();
        String str = UUID.randomUUID().toString().replaceAll("-","");
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14);
        return temp;
    }

//    private String Uuids(String string){
//        UUID uuid=UUID.randomUUID();
//        String str = UUID.randomUUID().toString();
//        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14);
//        String uuids = string + temp;
//        return uuids;
//    }

    public void add(User user){
    //   int i=1;

        String sql="insert into user value(?,?,?,?,?,0)";
        Connection conn=JdbcUtil.getConnection();

        try {
            user.setUid(Uuid());
            user.setCode(Uuid());
            qr.update(conn,sql,user.getUid(),user.getUsername()
                    ,user.getPassword(),user.getEmail(),user.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
 //       i++;
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public User findByEmail(String usernaem){
        String sql="select * from user where email=?";
        Connection conn= JdbcUtil.getConnection();
        User user=new User();

        try {
            user=qr.query(conn,sql,new BeanHandler<User>(User.class),user.getEmail());
            System.out.println("---"+user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
