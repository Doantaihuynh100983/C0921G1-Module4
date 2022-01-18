package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> getAllList();
    Blog findById(int id);
}
