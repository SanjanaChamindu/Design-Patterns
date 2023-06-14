import java.util.ArrayList;
import java.util.List;

public class PrototypeMain {
    public static void main(String[] args){
        BookShop bookShop1 = new BookShop();
        bookShop1.setShopName("Hello World");
        bookShop1.loadData();
        BookShop bookShop2 = bookShop1.clone();
        bookShop1.getBooks().remove(2);
        System.out.println(bookShop1);
        bookShop2.setShopName("Hello");
        System.out.println(bookShop2);
    }
}

class Book{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class BookShop implements Cloneable{
    private String shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }
    public void loadData(){
        for(int i=0; i<10; i++){
            var book = new Book();
            book.setId(i);
            book.setName("Book " + i);
            getBooks().add(book);
        }
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public BookShop clone() {
        // BookShop clone = (BookShop) super.clone();
        BookShop bookShop = new BookShop();
        for (Book book: this.getBooks()){
            bookShop.getBooks().add(book);
        }
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return bookShop;
    }
}