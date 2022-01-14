package vn.codegym.repository;


import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    private static final Map<Integer,Product> productList;
    static {
        productList = new LinkedHashMap<>();
        productList.put(1,new Product(1,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(2,new Product(2,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(3,new Product(3,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(4,new Product(4,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(5,new Product(5,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(6,new Product(6,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(7,new Product(7,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(8,new Product(8,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
        productList.put(9,new Product(9,"Banh Quy",56.6,"Binh Thuong","Kinh Do"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void addProduct(Product product) {
        productList.put(product.getId(),product);
    }
}
