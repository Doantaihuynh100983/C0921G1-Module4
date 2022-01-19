package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    void deleteById(int id);
}
