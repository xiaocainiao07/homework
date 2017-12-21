package homework.jdbcUtil;


import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) throws SQLException {
        Insert();}
       public static void Insert() throws SQLException {
    Connection conn= JdbcUtil.getConnection();
    PreparedStatement p=conn.prepareStatement("UPDATE  hw_user SET age=?,loc=? WHERE uname=?");


           Scanner input=new Scanner(System.in);
           String name=input.next();
           String age=input.next();
           String loc=input.next();

           p.setString(1,name);
           p.setString(1,age);
           p.setString(1,loc);


           p.executeUpdate();
           conn.close();
           p.close();


    }
}



