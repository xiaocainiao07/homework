package user.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class LoginAction extends ActionSupport implements ServletRequestAware {
    private UserDao userDao=new UserDao();
    private UserService userService=new UserService();
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    public String login() throws SQLException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        boolean login = userService.login(user);
        if (login){
            return "success";
        }
        return "error";
    }
//        User user = new User();
//
//        try {
//            BeanUtils.populate(user, request.getParameterMap());
//            String formName = user.getUsername();
//
//
//            User byUsername = userDao.findByUsername(formName);
//
//            if (byUsername != null) {
//                return "success";
//            }
//
//            userDao.insert(user);
//
//            if (byUsername==null){
//                return "false";
//            }
//
//
//
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//
//
//
   }



//}
