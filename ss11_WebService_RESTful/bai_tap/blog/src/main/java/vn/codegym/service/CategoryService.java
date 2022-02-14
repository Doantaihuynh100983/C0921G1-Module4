package vn.codegym.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Category;
import vn.codegym.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }
}
