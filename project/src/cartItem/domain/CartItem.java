package cartItem.domain;


import book.dao.Book;

public class CartItem {
    private Book book;
    private String amount;

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", amount=" + amount +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public CartItem() {

    }

    public CartItem(Book book, String amount) {

        this.book = book;
        this.amount = amount;
    }
}
