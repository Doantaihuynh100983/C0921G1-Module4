package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> getAllList(Pageable pageable);
    Page<Blog> findByAuthor(String title,Pageable pageable);
    Blog findById(int id);
    void deleteBlog(int id);
    void save(Blog blog);
}
