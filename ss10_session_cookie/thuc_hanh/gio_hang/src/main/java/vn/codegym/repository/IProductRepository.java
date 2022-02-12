package vn.codegym.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

@Repository
public interface  IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
