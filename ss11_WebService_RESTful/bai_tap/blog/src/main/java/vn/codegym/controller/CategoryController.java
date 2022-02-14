package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Category;
import vn.codegym.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = iCategoryService.getAllCategory();

        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
}
