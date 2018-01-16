package user.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


public class RegisterAction extends ActionSupport implements ServletRequestAware{
    private UserDao userDao=new UserDao();
    private UserService userService=new UserService();
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
    public String register() throws SQLException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        boolean register = userService.register(user);
        if (register){
            return "success";
        }
        return "error";
    }
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        try {
//            userDao.insert(user);
//            return SUCCESS;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;

//    try {
//        userService.login(user);
//        HttpSession session = request.getSession();
//        request.getSession().setAttribute("username",username);
//        request.getSession().setAttribute("password",password);
//        session.setAttribute("username", formU.getUsername());
//        return "f:/jsps/main.jsp";
//    } catch (LonginException e) {
//        request.setAttribute("errorMag", e.getMessage());
//        return "r:/jsps/user/login.jsp";
//
//    }



  //  }


}
