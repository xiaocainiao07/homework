package user.web;

import org.apache.commons.beanutils.BeanUtils;
import user.dao.User;
import user.daomain.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "registerServlet",urlPatterns = "/register")
public class registerServlet extends HttpServlet {
    private UserDao userDao=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            String username=user.getUsername();
            User a=userDao.findByUsername(username);
            if (a!=null){
                response.sendRedirect("/jsps/user/regist.jsp");
                return;
            }

            String email = user.getEmail();
            User b = userDao.findByEmail(email);
            if (b!=null){
                response.sendRedirect("/jsps/user/regist.jsp");
                return;
            }

            userDao.add(user);
            response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
