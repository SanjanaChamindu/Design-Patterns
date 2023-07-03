import java.util.ArrayList;

public class ProxyMain {
    public static void main(String[] args) {
        String book = "Hello World";
        IBookParser bookParser = new BookParserProxy(book);
        System.out.println(bookParser.getNumCharters());
    }
}

class BookParser{
    String book;
    public BookParser(String book){
        this.book = book; // Very expensive calculation
    }
    public int getNumCharacters(){
        return book.length();
    }
}

interface IBookParser{
    int getNumCharters();
}

class BookParserProxy implements IBookParser{
    private BookParser bookParser;
    private final String book;

    BookParserProxy(String book) {
        this.book = book;
    }

    @Override
    public int getNumCharters() {
        if (bookParser == null){
            this.bookParser = new BookParser(book);
            // Instantiate if its necessary, otherwise the expensive part will not be executed.
        }
        return bookParser.getNumCharacters();
    }
}