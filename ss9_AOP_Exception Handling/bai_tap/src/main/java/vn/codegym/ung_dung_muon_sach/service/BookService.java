package vn.codegym.ung_dung_muon_sach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.ung_dung_muon_sach.model.Book;
import vn.codegym.ung_dung_muon_sach.repository.IBookRepository;

import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void giveBack(Long id) {
        bookRepository.giveBack(id);
    }
}
