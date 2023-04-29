package TaskWorkStream7;

import java.util.Objects;

public class Book implements IBook {

    private String name;
    private String author;
    private int publishingYear;

    public Book() {
    }

    public Book(String name, String author, int publishingYear) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getPublishingYear() {
        return publishingYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return publishingYear == book.publishingYear && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publishingYear);
    }

    @Override
    public String toString() {
        return " Book " + name + ", " + author + ", " +publishingYear + ", " +
                '\n';
    }
}