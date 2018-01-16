package user.service;

import user.dao.UserDao;
import user.domain.User;

import java.sql.SQLException;

public class UserService {

    private UserDao userDao=new UserDao();

    public boolean login(User user) throws SQLException {
        User user1 = userDao.findByUsername(user.getUsername());
        System.out.println(user1);
        if (user1 == null || !user1.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;
    }
    public boolean register(User user) throws SQLException {
        User user1 = null;
        try {
            user1 = userDao.findByUsername(user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user1 != null){
            return false;
        }
        int i = userDao.insert(user);
        if (i == 1){
            return true;
        }
        return false;
    }
}