package dev.patika;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category" )
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",columnDefinition = "serial")
    private long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cat2book",
            joinColumns = {@JoinColumn(name = "cat2book_category_id")},
            inverseJoinColumns = {@JoinColumn(name = "cat2book_book_id")}
    )
    private List<Book> bookList;

    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
