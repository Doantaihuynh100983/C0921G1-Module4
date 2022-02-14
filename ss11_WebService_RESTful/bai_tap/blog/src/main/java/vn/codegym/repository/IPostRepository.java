package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Posts;

import java.util.List;

public interface IPostRepository extends JpaRepository<Posts,Integer> {


    @Query(value = "SELECT * FROM posts  WHERE id_category=?",nativeQuery = true)
    List<Posts> findByCategory(Integer id_category);
}
