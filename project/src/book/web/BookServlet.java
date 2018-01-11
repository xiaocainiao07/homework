package book.web;

import book.dao.Book;
import book.service.BookService;
import net.sf.json.JSONArray;
import user.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookService bs = new BookService();
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bs.findAll();
        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());

    }

    public void load(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Book book = bs.findBybid(bid);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/jsps/book/desc.jsp").include(request,response);

    }

    public void category(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("category");
        List<Book> books = bs.findBycid(cid);
        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());


    }
}



//        Book book = new Book();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        try {
//            BeanUtils.populate(Book,parameterMap);
//            String bid = book.getBid();
//            String bname = book.getBname();
//            String price = book.getPrice();
//            String author = book.getAuthor();
//            String image = book.getImage();
//            String cid = book.getCid();

//            if (forma != null) {
//                response.sendRedirect("/jsps/book/list.jsp");
//                return;
//            }

//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

//        String bname = book.getBname();
//        String email = user.getEmail();
//        User b = userDao.findByEmail(email);
//        if (b!=null){
//            response.sendRedirect("/jsps/user/regist.jsp");
//            return;
//        }

//            List<Book> carts = new ArrayList<>();
//            Book book = new Book();
//            book.setBid();
//            book.getBname();
//            book.getPrice();
//            book.getAuthor();
//            book.getImage();
//            book.getCid();
//            carts.add(book);
//            System.out.println(1);

//            request.setAttribute("Casts", carts);
//            request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request, response);
//
//        }
  //  }




 //   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        Book book=new Book();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//
//        try {
//            BeanUtils.populate(book,parameterMap);
//            String bname = book.getBname();
//            Book forma = categoryDao.findBybname(bname);

//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }




 //   }

//}
