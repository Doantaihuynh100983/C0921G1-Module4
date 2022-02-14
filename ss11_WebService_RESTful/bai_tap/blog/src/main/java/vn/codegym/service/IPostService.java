package vn.codegym.service;

import vn.codegym.model.Posts;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Posts> getAllPost();
    List<Posts> getFindByIdCategory(Integer id);
    Optional<Posts> getByIdPost(Integer id);
}
