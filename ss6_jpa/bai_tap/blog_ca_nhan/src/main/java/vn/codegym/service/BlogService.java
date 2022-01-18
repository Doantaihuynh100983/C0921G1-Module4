package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Blog> getAllList() {
        return ibLogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return ibLogRepository.findById(id);
    }
}
