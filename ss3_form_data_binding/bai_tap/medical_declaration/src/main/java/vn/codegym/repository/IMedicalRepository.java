package vn.codegym.repository;

import java.util.List;

public interface IMedicalRepository {
    List<String> quocTich();
    List<String> thongTinDiLai();
    List<String> tinhThanh();
    List<String> quanHuyen();
    List<String> phuongXa();
    List<String> trieuCHung();

}
