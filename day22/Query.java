package homework.jdbcUtil;


import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Query {
    public static void main(String[] args) throws SQLException {
      Query.query();
    }
    public static List<Object[]>query()throws SQLException{
        List<Object[]>query=new WhQueryRunner().query(JdbcUtil.getConnection(),"select*from hw_user",new ArrayListHandler());
        for(Object[]o:query){
            System.out.println(Arrays.toString(o));
        }
        return query;
    }





}