package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return iProductRepository.findById(id);
    }

}
