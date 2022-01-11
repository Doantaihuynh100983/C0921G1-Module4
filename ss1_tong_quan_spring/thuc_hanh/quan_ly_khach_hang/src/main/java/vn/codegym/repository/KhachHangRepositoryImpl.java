package vn.codegym.repository;

import vn.codegym.model.KhachHang;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class KhachHangRepositoryImpl implements IKhachHangRepository{

    private static final Map<Integer,KhachHang> khachHangs ;
    static {
        khachHangs = new HashMap<>();
       khachHangs.put(1,new KhachHang(1,"T","t@gmail.com","Da Nang"));
       khachHangs.put(2,new KhachHang(2,"Nhat","nhat@gmail.com","Quang Tri"));
       khachHangs.put(3,new KhachHang(3,"Trang","trang@gmail.com","Ha Noi"));
       khachHangs.put(4,new KhachHang(4,"Nguyen Binh Son","son@gmail.com","Sai Gon"));
       khachHangs.put(5,new KhachHang(5,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(6,new KhachHang(6,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(7,new KhachHang(7,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(8,new KhachHang(8,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(9,new KhachHang(9,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(10,new KhachHang(10,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(11,new KhachHang(11,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
       khachHangs.put(12,new KhachHang(12,"Dang Xuan Hoa","hoadang@gmail.com","Da Nang"));
    }
    @Override
    public List<KhachHang> getAllKhachHang() {
        return new ArrayList<>(khachHangs.values());
    }

    @Override
    public KhachHang getOneKhachHang(int id) {
        for (Map.Entry<Integer, KhachHang> entry : khachHangs.entrySet()) {
            if (entry.getKey() == id){
                return  entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void deleteKhachHang(int id) {
//        for (Map.Entry<Integer, KhachHang> entry : khachHangs.entrySet()) {
//            if (entry.getKey() == id){
//                khachHangs.remove(entry.getKey()) ;
//            }
//        }
        Iterator<Map.Entry<Integer, KhachHang>> itr = khachHangs.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer, KhachHang> entry = itr.next();
            if (entry.getKey() == id){
                khachHangs.remove(entry.getKey()) ;
            }
        }
    }

    @Override
    public void updateKhachHang(KhachHang khachHang) {

    }


}
