package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBLogRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService implements IBlogService{
    @Autowired
    IBLogRepository ibLogRepository;
    @Override
    public Page<Blog> getAllList(Pageable pageable) {
        return ibLogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByAuthor(String title, Pageable pageable) {
        return ibLogRepository.findByTitleContaining(title,pageable);
    }

    @Override
    public Blog findById(int id) {
        return ibLogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void deleteBlog(int id) {
        ibLogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        ibLogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByCategoryId(int id, Pageable pageable) {
        return ibLogRepository.findAllByCategoryId(id,pageable);
    }
}
