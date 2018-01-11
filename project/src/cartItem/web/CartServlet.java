package cartItem.web;

import book.dao.Book;
import book.service.BookService;
import cartItem.dao.CartDao;
import cartItem.domain.Cart;
import cartItem.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private BookService bs = new BookService();
    private CartDao cd = new CartDao();
    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Book book = bs.findBybid(bid);
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setAmount(request.getParameter("count"));


        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Map<String, CartItem> map = cart.getCart();
        map.put(book.getBid(),cartItem);
        response.sendRedirect(request.getContextPath()+"/jsps/cart/list.jsp");
    }

    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String bid = request.getParameter("bid");
        cd.delete(cart,bid);
        response.sendRedirect(request.getContextPath()+"/jsps/cart/list.jsp");
    }

    public void clear(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");

        cd.clear(cart);
        response.sendRedirect(request.getContextPath()+"/jsps/cart/list.jsp");
    }
}
