package vn.codegym.ung_dung_muon_sach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.ung_dung_muon_sach.model.Book;
import vn.codegym.ung_dung_muon_sach.model.CodeBook;
import vn.codegym.ung_dung_muon_sach.repository.ICodeBookRepository;

@Service
@Transactional
public class CodeBookService implements ICodeBookService{
    @Autowired
    ICodeBookRepository codeBookRepository;

    @Override
    public int saveCodeBook(Book book) {
        double random=Math.random()*99999+10000;
        CodeBook codeBook=new CodeBook((long) random, book);
        codeBookRepository.save(codeBook);
        return (int) random;
    }

    @Override
    public void delete(Long codeBook) {
        codeBookRepository.deleteByCodeBook(codeBook);
    }

    @Override
    public CodeBook findByCodeBook(Long codeBook) {
        return codeBookRepository.findByCodeBook(codeBook);
    }
}
