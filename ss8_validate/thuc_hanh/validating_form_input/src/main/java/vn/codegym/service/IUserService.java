package vn.codegym.service;

import vn.codegym.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void addUser(User user);
}
