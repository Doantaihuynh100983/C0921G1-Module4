package vn.codegym.service;

import vn.codegym.model.KhachHang;

import java.util.List;

public interface IKhachHangService {
    List<KhachHang> getAllKhachHang();
    KhachHang getOneKhachHang(int id);
    void deleteKhachHang(int id);
    void updateKhachHang(KhachHang khachHang);
}
