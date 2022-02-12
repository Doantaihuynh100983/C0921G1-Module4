package vn.codegym.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;
    private String type;
    private String author;

    @OneToMany(mappedBy = "book")
    private Set<CodeBook> codeBooks;

    public Book() {
    }

    public Book(String name, Long quantity, String type, String author, Set<CodeBook> codeBooks) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.author = author;
        this.codeBooks = codeBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long bookId) {
        this.id = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<CodeBook> getCodeBooks() {
        return codeBooks;
    }

    public void setCodeBooks(Set<CodeBook> codeBooks) {
        this.codeBooks = codeBooks;
    }
}
