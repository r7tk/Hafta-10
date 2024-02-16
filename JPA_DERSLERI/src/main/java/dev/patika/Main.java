package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();



        transaction.begin();

      /*  // Supplier Ekleme
        Supplier supplier = new Supplier();
        supplier.setAddress("Adres");
        supplier.setCompany("Patika");
        supplier.setContact("500056465454");
        supplier.setMail("info@patika.dev");
        supplier.setPerson("Ömer Faruk BARAN");
        entityManager.persist(supplier);


        // Category Ekleme
        Category category = new Category();
        category.setName("Telefonlar");
        entityManager.persist(category);



        // Code Ekleme
        Code code = new Code();
        code.setGroup("12345");
        code.setSerial("67890");
        entityManager.persist(code);


        // Ürün Ekleme
        Product product = new Product();
        product.setName("Iphone 15 Pro");
        product.setPrice(1234);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        entityManager.persist(product);
*/
        product.setCategory(category);

        System.out.println(product.toString());*/


        Color blue = new Color("Blue");
        Color red = new Color("Red");
        Color yellow = new Color("Yellow");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(yellow);

        Product product = entityManager.find(Product.class,1);
        List<Color> colorList = new ArrayList<>();
        colorList.add(blue);
        colorList.add(red);
        colorList.add(yellow);
        product.setColorList(colorList);
        entityManager.persist(product);
        transaction.commit();
        // CRUD
        /*transaction.begin();
        Costumer costumer = entityManager.find(Costumer.class,1);

        entityManager.remove(costumer);
        transaction.commit();*/
    }
}