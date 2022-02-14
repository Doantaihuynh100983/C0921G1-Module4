package vn.codegym.model;


import javax.persistence.*;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;
    private String namePost;
    private String author;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idCategory",referencedColumnName = "idCategory")
    private Category category;

    public Posts() {
    }

    public Posts(Integer idPost, String namePost, String author, String description, Category category) {
        this.idPost = idPost;
        this.namePost = namePost;
        this.author = author;
        this.description = description;
        this.category = category;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
