package TaskWorkStream7;

import java.util.ArrayList;
import java.util.List;

/**
 *  1 уровень сложности: Необходимо смоделировать библиотеку. Для каждой книги библиотечного фонда известны автор,
 *  название и год издания. Для читателя библиотеки будем хранить ФИО и электронный адрес (объекты типа EmailAddress).
 *  Каждый читатель может взять в библиотеке одну или несколько книг - их тоже сохраним.
 *  Ещё нам понадобится флаг читательского согласия на уведомления по электронной почте.
 *  Рассылки организуют сотрудники библиотеки: напоминают о сроке возврата книг, сообщают новости.
 * Разработайте соответствующие классы.
 * Task 1. Получить список всех книг библиотеки, отсортированных по году издания.
 * Task 2. Требуется создать список рассылки (объекты типа EmailAddress) из
 * адресов всех читателей библиотеки. При этом флаг согласия на рассылку учитывать не будем:
 * библиотека закрывается, так что хотим оповестить всех.
 * Task 3. Снова нужно получить список рассылки. Но на этот раз включаем в него
 * только адреса читателей, которые согласились на рассылку. Дополнительно нужно проверить,
 * что читатель взял из библиотеки больше одной книги.
 * Task 4. Получить список всех книг, взятых читателями. Список не должен содержать дубликатов
 * (книг одного автора, с одинаковым названием и годом издания).
 * Task 5. Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
 * Task 6. Узнать наибольшее число книг, которое сейчас на руках у читателя.
 * Task 7*. Вернёмся к нашим email-рассылкам. Теперь нужно не просто отправить письма всем, кто
 * согласился на рассылку, — будем рассылать разные тексты двум группам:
 *
 тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;

 тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.

 То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress):
 с пометкой OK — если книг не больше двух, или TOO_MUCH — если их две и больше. Порядок групп не важен.
 Можно решить любое количество задач. Все задачи будем разбирать на занятии. Единственное условие:
 попробуйте решить все задачи с помощью Stream API.
 */
public class Main {

    public static void main(String[] args) {

        IEmail email1 = new Email(false,"sandra@gmail.com");
        IEmail email2 = new Email(false,"tamara@gmail.com");
        IEmail email3 = new Email(true,"peter@gmail.com");
        IEmail email4 = new Email(true,"alex@gmail.com");
        IEmail email5 = new Email(true,"oleg@gmail.com");

        List<IBook> bookList = new ArrayList<>();
        Book book1 = new Book("SIMPLY LIES", "David Baldacci", 2022);
        Book book2 = new Book("SIMPLY LIES", "David Baldacci", 2022);
        Book book3 = new Book("THE LAST THING HE TOLD ME", "Laura Dave", 2022);
        Book book4 = new Book("THE LAST THING HE TOLD ME", "Laura Dave", 2022);
        Book book5 = new Book("IT ENDS WITH US", "Colleen Hoover", 2023);
        Book book6 = new Book("IT ENDS WITH US", "Colleen Hoover", 2023);
        Book book7 = new Book("THE WAGER", "David Grann", 2022);
        Book book8 = new Book("THE WAGER", "David Grann", 2022);
        Book book9 = new Book("HELLO BEAUTIFUL", "Ann Napolitano", 2022);
        Book book10 = new Book("HELLO BEAUTIFUL", "Ann Napolitano", 2022);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);

        List<IReader> readerList = new ArrayList<>();
        Reader reader1 = new Reader("Inga", "Ivanova", email1);
        Reader reader2 = new Reader("Peter", "Ivanov", email2);
        Reader reader3 = new Reader("Sveta", "Stepanova", email3);
        Reader reader4 = new Reader("Oleg", "Gazmanov", email4);
        Reader reader5 = new Reader("Violeta", "Rubenstein", email5);
        reader1.addBook(book1);
        reader2.addBook(book2);
        reader2.addBook(book3);
        reader3.addBook(book4);
        reader3.addBook(book5);
        reader3.addBook(book6);
        reader4.addBook(book7);
        reader4.addBook(book8);
        reader5.addBook(book9);
        reader5.addBook(book10);
        readerList.add(reader1);
        readerList.add(reader2);
        readerList.add(reader3);
        readerList.add(reader4);
        readerList.add(reader5);

        Library library = new Library(readerList, bookList);
        //Task1
        library.sortListPerYear(bookList);
        //Task2
        String message = "библиотека закрывается, так что хотим оповестить всех";
        library.sendEmailsWithoutAccept(readerList, message);
        //Task3
        library.sendEmailsWithAccept(readerList);
        //Task4
        library.listUniqueBook(readerList);
        //Task5
        String book = "David Baldacci";
        library.findBook(readerList, book);
        //Task6
        library.findMaxBook(readerList);
        //Task7
        String message1 = "расскажем о новинках библиотеки";
        String message2 = "напомним о том, что их нужно вернуть в срок.";
        library.sendNews(readerList, message1, message2);
        System.out.println(readerList);

    }
}