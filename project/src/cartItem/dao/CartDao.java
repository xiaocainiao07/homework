package cartItem.dao;

import cartItem.domain.Cart;
import cartItem.domain.CartItem;

import java.util.Map;

public class CartDao {

    public void delete(Cart cart, String bid) {
//        Book bybid = bookDao.findBybid(bid);
        Map<String, CartItem> map = cart.getCart();
        if (map!=null) {
            map.remove(bid);
        }

    }

    public void clear(Cart cart) {
        Map<String, CartItem> cart1 = cart.getCart();
        for (String s : cart1.keySet()) {
            cart1.remove(s);
        }
    }
}
