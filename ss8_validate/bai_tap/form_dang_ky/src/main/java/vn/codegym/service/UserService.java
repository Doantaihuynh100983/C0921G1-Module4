package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.User;
import vn.codegym.repository.IUserRepository;

import java.util.List;
@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
