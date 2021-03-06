package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public void editProduct(Product product) {
        iProductRepository.editProduct(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        return  iProductRepository.searchProduct(nameProduct);
    }
}
