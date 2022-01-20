package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;

public interface IBLogRepository extends JpaRepository<Blog,Integer> {

    void deleteById(int id);
    Page<Blog> findByTitleContaining(String title , Pageable pageable);
    Page<Blog> findAllByCategoryId(int id , Pageable pageable);
}
