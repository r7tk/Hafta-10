package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // Author Ekleme

        Author author = new Author();
        author.setName("Sabahattin Ali");
        author.setBirthDate(LocalDate.of(1907, 2, 25));
        author.setCountry("Bulgaristan");
        entityManager.persist(author);

        // Book Ekleme

        Book book = new Book();
        book.setAuthor(entityManager.find(Author.class,1));
        book.setName("Kürk Mantolu Madonna");
        book.setPublicYear(1943);
        book.setStock(50);
        book.setPublisher(entityManager.find(Publisher.class,1));
        entityManager.persist(book);

        // Category Ekleme

        Category category = new Category();
        category.setName("Edebiyat");
        category.setDescription("Birşeyler Yazdım Bak");
        entityManager.persist(category);

        // Publisher Ekleme

        Publisher publisher = new Publisher();
        publisher.setName("Sel Yayıncılık");
        publisher.setEstablishmentYear(1990);
        publisher.setAddress("İstanbul");
        entityManager.persist(publisher);

        // BookBorrowing Ekleme
       /* BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setName("ÖMER FARUK BARAN");
        bookBorrowing.setDate(LocalDate.of(2024,2,10));
        bookBorrowing.setReturnDate(LocalDate.of(2024,2,15));
        bookBorrowing.setBook(entityManager.find(Book.class,1));  // bunu unutma not null hatası bu yüzden alıyorsun
        entityManager.persist(bookBorrowing);*/
        transaction.commit();


    }
}