package user.web;

import org.apache.commons.beanutils.BeanUtils;
import user.dao.User;
import user.daomain.UserDao;
import user.service.UserService;
import user.service.exception.LoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User fromU=new User();
        fromU.setUsername(username);
        fromU.setPassword(password);
        fromU.setEmail(email);

        try {
            User login = userService.login(fromU);
            request.getSession().setAttribute("user",login);
            response.sendRedirect("/jsps/main.jsp");

        } catch (LoginException e) {
            request.setAttribute("errorMsg",e.getMessage());
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }


//            request.setCharacterEncoding("utf-8");
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        User user=new User();
//
//        try {
//            BeanUtils.populate(user,parameterMap);
//            User a = userDao.findByUsername(user.getUsername());
//            if (user.getUsername().equals(a.getUsername())){
//                if (user.getPassword().equals(a.getPassword())){
//                    Cookie cookie=new Cookie("user",user.getUsername());
//                    cookie.setMaxAge(60*60*24*30);
//                    response.addCookie(cookie);
//                    request.getSession().setAttribute("user",user.getPassword());
//                    request.getRequestDispatcher("/jsps/main.jsp").forward(request,response);
//
//                }else {
//                    System.out.println("密码错误");
//                }
//
//            }else {
//                System.out.println("用户名错误");
//            }
//
//
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
