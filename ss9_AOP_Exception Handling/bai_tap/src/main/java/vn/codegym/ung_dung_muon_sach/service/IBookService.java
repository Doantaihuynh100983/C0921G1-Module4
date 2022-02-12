package vn.codegym.ung_dung_muon_sach.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.ung_dung_muon_sach.model.Book;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    Optional<Book> findById(Long id);
    void save(Book book);
    void giveBack(Long id);
}
