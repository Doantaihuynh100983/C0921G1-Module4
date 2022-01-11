package vn.codegym.repository;

import vn.codegym.model.KhachHang;

import java.util.List;


public interface IKhachHangRepository {
      List<KhachHang> getAllKhachHang();
      KhachHang getOneKhachHang(int id);
      void deleteKhachHang(int id);
      void updateKhachHang(KhachHang khachHang);
}
