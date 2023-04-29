package TaskWorkStream7;

import java.util.List;

public interface IReader {
    List<Book> getBookList();
    String getName();
    String getSurname();
    IEmail getEmail();

}