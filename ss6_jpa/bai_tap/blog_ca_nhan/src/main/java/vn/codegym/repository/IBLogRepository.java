package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;

public interface IBLogRepository extends JpaRepository<Blog,Integer> {

    void deleteById(int id);
}
