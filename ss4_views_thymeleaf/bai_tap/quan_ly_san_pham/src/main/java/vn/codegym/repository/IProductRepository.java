package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void addProduct(Product product);
}
