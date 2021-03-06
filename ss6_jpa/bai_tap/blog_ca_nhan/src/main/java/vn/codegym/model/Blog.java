package vn.codegym.model;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private Date date;
    private String image;
    private String description;
    private String content;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String author, Date date, String image, String description, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.image = image;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
