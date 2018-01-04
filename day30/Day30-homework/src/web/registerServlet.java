package web;

import bean.User;

import dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by zyf on 2018/1/3.
 */
@WebServlet(name = "registerServlet",urlPatterns = "/register")
public class registerServlet extends HttpServlet {
	private UserDao userDao=new UserDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		Map<String, String[]> parameterMap =
				request.getParameterMap();
		try {
			BeanUtils.populate(user,parameterMap);
			String formName = user.getUsername();
			User fromDb = userDao.queryByUsername(formName);

			if(fromDb != null){
				//说明已经注册了
				response.sendRedirect("/register.html");

				return;
			}

//			if(userDao.queryByUsername(
//					user.getUsername()
//			).getUsername() == null)

			userDao.insert(user);

			response.sendRedirect("/login.html");


		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
