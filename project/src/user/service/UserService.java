package user.service;

import user.dao.User;
import user.daomain.UserDao;
import user.service.exception.InvalidUsernameException;
import user.service.exception.LoginException;
import user.service.exception.PasswordNotchedException;

public class UserService {
    private UserDao userDao=new UserDao();

    public User login(User user) throws LoginException {
        User fromDb = userDao.findByUsername(user.getUsername());

        if (fromDb==null){
            throw new InvalidUsernameException();
        }
        //
        if (!fromDb.getPassword().equals(user.getPassword())){
            //抛出密码不匹配异常
            throw new PasswordNotchedException();
        }
        return fromDb;
    }


}
