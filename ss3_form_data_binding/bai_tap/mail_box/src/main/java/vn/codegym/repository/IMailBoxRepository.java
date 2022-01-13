package vn.codegym.repository;

import vn.codegym.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    List<MailBox> getAllMailBox();
    List<String> getAllLanguges();
    List<Integer> getAllPageSize();
    void addNewMaiBox(MailBox mailBox);
    MailBox getMailBoxById(int id);
    void updateMailBox(MailBox mailBox);
}
