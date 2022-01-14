package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void addProduct(Product product);
    void deleteProduct(int id);
    void editProduct(Product product);
    Product findById(int id);
    List<Product> searchProduct(String nameProduct);
}
