package vn.codegym.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Posts;
import vn.codegym.repository.IPostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService{

    @Autowired
    IPostRepository iPostRepository;

    @Override
    public List<Posts> getAllPost() {
        return iPostRepository.findAll();
    }

    @Override
    public List<Posts> getFindByIdCategory(Integer id) {
        return iPostRepository.findByCategory(id);
    }

    @Override
    public Optional<Posts> getByIdPost(Integer id) {
        return iPostRepository.findById(id);
    }
}
