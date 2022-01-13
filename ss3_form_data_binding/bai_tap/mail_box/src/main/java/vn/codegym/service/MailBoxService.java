package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.MailBox;
import vn.codegym.repository.IMailBoxRepository;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService{
    @Autowired
    IMailBoxRepository iMailBoxRepository ;
    @Override
    public List<MailBox> getAllMailBox() {
        return iMailBoxRepository.getAllMailBox();
    }

    @Override
    public List<String> getAllLanguges() {
        return iMailBoxRepository.getAllLanguges();
    }

    @Override
    public List<Integer> getAllPageSize() {
        return iMailBoxRepository.getAllPageSize();
    }

    @Override
    public void addNewMaiBox(MailBox mailBox) {
        iMailBoxRepository.addNewMaiBox(mailBox);
    }

    @Override
    public MailBox getMailBoxById(int id) {
        return iMailBoxRepository.getMailBoxById(id);
    }

    @Override
    public void updateMailBox(MailBox mailBox) {
        iMailBoxRepository.updateMailBox(mailBox);
    }
}
