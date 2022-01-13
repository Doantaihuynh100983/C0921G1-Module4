package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.MailBox;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailBoxRepository implements  IMailBoxRepository{
        private static final List<MailBox> mailBoxList;
        private static final List<String> laguagesLIST;
        private static final List<Integer> pageSizeLIST;
        static {
            mailBoxList = new ArrayList<>();
            mailBoxList.add(new MailBox(1,"English",5,true,"King"));
            mailBoxList.add(new MailBox(2,"Vietnamese",10,true,"King"));
            mailBoxList.add(new MailBox(3,"Japanese",15,true,"King"));
            mailBoxList.add(new MailBox(4,"Chinese",25,true,"King"));
            mailBoxList.add(new MailBox(5,"English",50,true,"King"));
            laguagesLIST = new ArrayList<>();
            laguagesLIST.add("English");
            laguagesLIST.add("Vietnamese");
            laguagesLIST.add("Japanese");
            laguagesLIST.add("Chinese");
            pageSizeLIST= new ArrayList<>();
            pageSizeLIST.add(5);
            pageSizeLIST.add(10);
            pageSizeLIST.add(15);
            pageSizeLIST.add(25);
            pageSizeLIST.add(50);
            pageSizeLIST.add(100);
        }


    @Override
    public List<MailBox> getAllMailBox() {
        return mailBoxList;
    }

    @Override
    public List<String> getAllLanguges() {
        return laguagesLIST;
    }

    @Override
    public List<Integer> getAllPageSize() {
        return pageSizeLIST;
    }

    @Override
    public void addNewMaiBox(MailBox mailBox) {
             mailBoxList.add(mailBox);
    }

    @Override
    public MailBox getMailBoxById(int id) {
        for (int i = 0; i < mailBoxList.size(); i++){
            if (mailBoxList.get(i).getId()==id){
                return mailBoxList.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateMailBox(MailBox mailBox) {
        mailBoxList.set(mailBox.getId()-1,mailBox);
    }
}
