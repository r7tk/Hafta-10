package dev.patika;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",columnDefinition = "serial")
    private long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_publicationYear")
    private int publicYear;

    @Column(name = "book_stock")
    private int stock;

    @ManyToMany(mappedBy = "bookList",fetch = FetchType.LAZY)
    private List<Category> categoryList;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    private List<BookBorrowing> bookBorrowingList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_book_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_book_id",referencedColumnName = "author_id")
    private Author author;

    public Book() {
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<BookBorrowing> getBookBorrowingList() {
        return bookBorrowingList;
    }

    public void setBookBorrowingList(List<BookBorrowing> bookBorrowingList) {
        this.bookBorrowingList = bookBorrowingList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicYear=" + publicYear +
                ", stock=" + stock +
                ", categoryList=" + categoryList +
                ", bookBorrowingList=" + bookBorrowingList +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }
}
