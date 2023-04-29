package TaskWorkStream7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements ILibrary {
    private List<IReader> readerList;
    private List<IBook> bookList;

    public Library() {
    }

    public Library(List<IReader> readerList, List<IBook> bookList) {
        this.readerList = readerList;
        this.bookList = bookList;
    }

    public Library(List<IBook> bookList) {
        this.bookList = bookList;
    }

    @Override
    public List<IReader> getReaderList() {
        return readerList;
    }

    @Override
    public List<IBook> getBookList() {
        return bookList;
    }

    public void setBookList(List<IBook> bookList) {
        this.bookList = bookList;
    }

    public void setReaderList(List<IReader> readerList) {
        this.readerList = readerList;
    }

    /**
     * Task 1 Получить список всех книг библиотеки, отсортированных по году издания.
     */
    public void sortListPerYear(List<IBook> bookList) {
        System.out.println(bookList.stream()
                .sorted(Comparator.comparingInt(IBook::getPublishingYear))
                .collect(Collectors.toList()));
    }

    /**
     * Task 2. Требуется создать список рассылки (объекты типа EmailAddress)
     * из адресов всех читателей библиотеки. При этом флаг согласия на
     * рассылку учитывать не будем: библиотека закрывается,
     * так что хотим оповестить всех.
     */
    public void sendEmailsWithoutAccept(List<IReader> readerList, String message) {
        readerList.stream()
                .map(x -> x.getEmail())
                .peek(x -> System.out.println(x.getEmail() + " " + message))
                .toList();
    }

    /**
     * Task 3. Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
     * которые согласились на рассылку. Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
     */

    public void sendEmailsWithAccept(List<IReader> readerList) {
        readerList.stream()
                .filter(x -> x.getBookList().size() > 1)
                .map(x -> x.getEmail())
                .filter(x -> x.isAccept())
                .peek(x -> System.out.println(x.getEmail()))
                .toList();
    }

    /**
     * Task 4. Получить список всех книг, взятых читателями. Список не должен содержать
     * дубликатов (книг одного автора, с одинаковым названием и годом издания).
     */
    public void listUniqueBook(List<IReader> readerList) {
        System.out.println(readerList.stream()
                .map(x -> x.getBookList())
                .flatMap(x -> x.stream())
                .distinct()
                .collect(Collectors.toList()));
    }

    /**
     * Task 5. Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
     */

    public void findBook(List<IReader> readerList, String author) {
        System.out.println(readerList.stream()
                .map(x -> x.getBookList())
                .flatMap(x -> x.stream())
                .filter(x -> x.getAuthor().equals(author))
                .collect(Collectors.toList()));
    }

    /**
     * Task 6. Узнать наибольшее число книг, которое сейчас на руках у читателя.
     */

    public void findMaxBook(List<IReader> readerList) {
        System.out.println(readerList.stream()
                .map(x -> x.getBookList().size())
                .max(Integer::compareTo));
    }

    /**
     *
     * Task 7*. Вернёмся к нашим email-рассылкам.
     * Теперь нужно не просто отправить письма всем,
     * кто согласился на рассылку, — будем рассылать разные
     * тексты двум группам:

     тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;

     тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
     То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress):
     с пометкой OK — если книг не больше двух, или TOO_MUCH — если их две и больше. Порядок групп не важен.
     */

    public void sendNews(List<IReader> readerList, String message1, String message2) {
        readerList.stream()
                .filter(x -> x.getBookList().size() < 2)
                .forEach(x -> System.out.println(x.getEmail() + message1));
        readerList.stream()
                .filter(x -> x.getBookList().size() > 2)
                .forEach(x -> System.out.println(x.getEmail() + message2));
    }
}