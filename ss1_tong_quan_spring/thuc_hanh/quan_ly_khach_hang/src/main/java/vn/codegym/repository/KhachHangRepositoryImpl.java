package vn.codegym.repository;

import vn.codegym.model.KhachHang;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class KhachHangRepositoryImpl implements IKhachHangRepository{

    private static final List<KhachHang> khachHangs ;
    static {
        khachHangs = new ArrayList<>();
       khachHangs.add(new KhachHang(1,"T","t@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(2,"Nhat","nhat@gmail.com","Quang Tri"));
       khachHangs.add(new KhachHang(3,"Trang","trang@gmail.com","Ha Noi"));
       khachHangs.add(new KhachHang(4,"Nguyen Binh Son","son@gmail.com","Sai Gon"));
       khachHangs.add(new KhachHang(5,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(6,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(7,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(8,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(9,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(10,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(11,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.add(new KhachHang(12,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
    }
    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangs;
    }

    @Override
    public KhachHang getOneKhachHang(int id) {
        for (int i = 0; i < khachHangs .size(); i++) {
            if (khachHangs.get(i).getId() == id) {
                return khachHangs.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteKhachHang(int id) {
        for (int i = 0; i < khachHangs .size(); i++) {
            if (khachHangs.get(i).getId() == id) {
                 khachHangs.remove(khachHangs.get(i));
            }
        }
    }

    @Override
    public void updateKhachHang(KhachHang khachHang) {
        for (int i = 0; i < khachHangs.size() ; i++) {
            if (khachHangs.get(i).getId() == khachHang.getId()){
                khachHangs.get(i).setId(khachHang.getId());
                khachHangs.get(i).setName(khachHang.getName());
                khachHangs.get(i).setEmail(khachHang.getEmail());
                khachHangs.get(i).setAdress(khachHang.getAdress());
            }
        }
    }


}
