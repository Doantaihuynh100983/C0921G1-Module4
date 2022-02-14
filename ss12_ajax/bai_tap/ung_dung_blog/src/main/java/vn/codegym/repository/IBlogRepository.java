package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
