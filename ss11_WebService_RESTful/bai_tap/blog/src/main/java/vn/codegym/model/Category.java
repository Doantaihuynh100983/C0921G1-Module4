package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Posts> postsSet;

    public Category() {
    }

    public Category(Integer idCategory, String nameCategory, List<Posts> postsSet) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.postsSet = postsSet;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Posts> getPostsSet() {
        return postsSet;
    }

    public void setPostsSet(List<Posts> postsSet) {
        this.postsSet = postsSet;
    }
}
