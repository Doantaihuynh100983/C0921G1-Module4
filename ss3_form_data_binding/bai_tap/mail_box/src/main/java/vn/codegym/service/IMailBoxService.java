package vn.codegym.service;

import vn.codegym.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    List<MailBox> getAllMailBox();
    List<String> getAllLanguges();
    List<Integer> getAllPageSize();
    void addNewMaiBox(MailBox mailBox);
    MailBox getMailBoxById(int id);
    void updateMailBox(MailBox mailBox);
}
