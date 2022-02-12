package vn.codegym.ung_dung_muon_sach.model;

import javax.persistence.*;

@Entity
public class CodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codeBook;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id" )
    private Book book;

    public CodeBook() {
    }

    public CodeBook(Long codeBook, Book book) {
        this.codeBook = codeBook;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(Long codeBook) {
        this.codeBook = codeBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
