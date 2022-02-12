package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProduct();
    Optional<Product> findById(Integer id);
}
