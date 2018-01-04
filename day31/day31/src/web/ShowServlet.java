package web;

import bean.Book;
import bean.User;

import dao.BookDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zyf on 2018/1/3.
 */
@WebServlet(name = "ShowServlet",urlPatterns ="/show")
public class ShowServlet extends HttpServlet {
	private BookDao bookDao=new BookDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		List<Book> books = bookDao.showAll();
		JSONArray jsonArray = JSONArray.fromObject(books);
		response.getWriter().write(jsonArray.toString());


	}
}
