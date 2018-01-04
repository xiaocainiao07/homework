package web;

import bean.User;

import dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by zyf on 2018/1/3.
 */
@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class loginServlet extends HttpServlet {
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		System.out.println("登录成功");
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap =
				request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user,parameterMap);
			User u = userDao.queryByUsername(user.getUsername());
			if(user.getUsername().equals(u.getUsername())){
				if(user.getPassword().equals(u.getPassword())){
						//成功
					//HttpSession session = request.getSession();
//					Cookie[] cookies = request.getCookies();
//					for (Cookie cookie : cookies) {
//						System.out.println(cookie.getName()+"="+cookie.getValue());
//					}
					Cookie cookie = new Cookie("user", user.getUsername());

					//cookie.setPath("/cookie");
					cookie.setMaxAge(60*60*24*30);
                   response.addCookie(cookie);
				//	System.out.println(cookie);
					//存在哪儿，访问index时可以获取到
						//存到ServletContext中
					//	getServletContext().setAttribute("user",user);
					request.getSession().setAttribute("user",user);

						request.getRequestDispatcher("/index.jsp")
								.forward(request,response);

						return ;




				}else {
					System.out.println("密码错误");
				}
			}else {
				System.out.println("无用户名");
			}

			System.out.println("哈哈哈哈哈哈");

			response.sendRedirect("/login.jsp");

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("12345");
	}
}
