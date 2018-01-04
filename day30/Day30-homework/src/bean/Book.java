package bean;

public class Book {
    private String bookname;
    private String zzname;
    private String price;

    public Book(String bookname, String zzname, String price) {
        this.bookname = bookname;
        this.zzname = zzname;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", zzname='" + zzname + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getZzname() {
        return zzname;
    }

    public void setZzname(String zzname) {
        this.zzname = zzname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
