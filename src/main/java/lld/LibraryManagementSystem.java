package lld;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
}

enum BookStatus {
    AVAILABLE,
    LOANED,
    LOST
}

enum AccountStatus{
    ACTIVE,
    CLOSED,
    BLACKLISTED
}
class Constants {
    public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
    public static final int MAX_LENDING_DAYS = 10;
}

abstract class Book {
    private String title;
    private String subject;
    private String publisher;
    private List<Author> authors;
}

class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly; //not eligible for checkout
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;
}

class Rack {
    private int number;
    private String locationIdentifier;
}

class LibraryCard{
    private String cardNumber;
    private String  barCode;
    private Date issuedAt;
    private boolean isActive;
}
abstract class Account {
    private String id;
    private String userName;
    private String password;
    private AccountStatus status;
    private LibraryCard libraryCard;
}
abstract class Librarian extends Account {
    abstract public boolean addBookItem(BookItem bookItem);
    abstract public boolean blockMember(Member member);
    abstract public boolean unBlockMember(Member member);
    abstract public boolean cancelMembership(Member member);
}
abstract class Member extends Account {
    Date dateOfMembership;
    int totalBooksCheckedout;
    public abstract void incrementTotalBooksCheckedout();
    public abstract void checkoutBook(BookItem item);
    public abstract void returnBookItem(BookItem item);
    public abstract void renewBookItem(BookItem item);
    public abstract void checkForFine(String barCode);
}
class Author extends Account {
    private int booksPublished;
    List<Book> book;
}
abstract class BookLending {
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private String bookItemBarcode;
    private String memberId;

    abstract void lendBook(String barcode, String memberId);
    abstract BookLending fetchLendingDetails(String barcode);
}
abstract class Fine {
    private Date creationDate;
    private double bookItemBarcode;
    private String memberId;
    private double amount;
    public abstract void collectFine(String memberId, long days);
}

class Inventory{
    String title;
    List<Book> copies;
}

enum ReckSpotStatus{
    FREE,
    OCCUPIED
}

interface Search {
    public List<Book> searchByTitle(String title);
    public List<Book> searchByAuthor(String author);
    public List<Book> searchBySubject(String subject);
    public List<Book> searchByPubDate(Date publishDate);
}

class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    public List<Book> searchByTitle(String query) {
        return bookTitles.get(query);
    }

    public List<Book> searchByAuthor(String query) {
        return bookAuthors.get(query);
    }

    public List<Book> searchBySubject(String query) {
        return bookSubjects.get(query);
    }

    public List<Book> searchByPubDate(Date query) {
        return bookPublicationDates.get(query);
    }
}
