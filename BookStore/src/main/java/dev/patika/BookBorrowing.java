package dev.patika;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookborrowing")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bb_id" , columnDefinition = "serial")
    private long id;

    @Column(name = "bb_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "bb_date")
    private LocalDate date;

    @Temporal(TemporalType.DATE)
    @Column(name = "bb_return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "book_b_id",referencedColumnName = "book_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookBorrowing() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", returnDate=" + returnDate +
                ", book=" + book +
                '}';
    }
}
