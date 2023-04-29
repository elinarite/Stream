package TaskWorkStream7;

import java.util.ArrayList;
import java.util.List;

public class Reader implements IReader {

    private String name;
    private String surname;
    private IEmail email;
    private List<Book> bookList =new ArrayList<>();

    public Reader() {
    }

    public Reader(String name, String surname, IEmail email, List<Book> bookList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bookList = bookList;
    }

    public Reader(String name, String surname, IEmail email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public IEmail getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(IEmail email) {
        this.email = email;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    public void addBook(Book book){
        bookList.add(book);
    }

    @Override
    public String toString() {
        return ""+name + ", " + surname + ", " + email + ", " + bookList;

    }
}