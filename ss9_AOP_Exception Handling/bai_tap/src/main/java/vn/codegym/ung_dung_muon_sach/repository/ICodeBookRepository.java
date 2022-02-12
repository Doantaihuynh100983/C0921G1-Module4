package vn.codegym.ung_dung_muon_sach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.ung_dung_muon_sach.model.CodeBook;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook, Long> {
    @Modifying
    void deleteByCodeBook(Long codeBook);
    CodeBook findByCodeBook(Long codeBook);
}
