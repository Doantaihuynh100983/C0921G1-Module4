package vn.codegym.ung_dung_muon_sach.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.ung_dung_muon_sach.model.Book;


@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value="update book set quantity= quantity+1 where id = :id", nativeQuery=true)
    void giveBack(Long id);
//
//    @Query(value="update book set quantity= quantity-1 where id = :id", nativeQuery=true)
//    void rent(Long id);
}
