package homework.jdbcUtil;


import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Update.lnsert();
    }
    public static void lnsert() throws ClassNotFoundException, SQLException {
        Scanner input=new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day20",
                "root",
                "123");
        PreparedStatement p=conn.prepareCall("INSERT  INTO  hw_user VALUES (NULL ,???)");

        System.out.println("输入");


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








