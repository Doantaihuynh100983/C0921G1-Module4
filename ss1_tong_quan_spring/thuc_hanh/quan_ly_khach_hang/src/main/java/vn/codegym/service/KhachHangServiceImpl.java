package vn.codegym.service;

import vn.codegym.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.IKhachHangRepository;
import vn.codegym.repository.KhachHangRepositoryImpl;

import java.util.List;

@Service
public class KhachHangServiceImpl implements IKhachHangService{

    @Autowired
    private IKhachHangRepository iKhachHangRepository;


    @Override
    public List<KhachHang> getAllKhachHang() {
        return  iKhachHangRepository.getAllKhachHang();
    }

    @Override
    public KhachHang getOneKhachHang(int id) {
        return iKhachHangRepository.getOneKhachHang(id);
    }

    @Override
    public void deleteKhachHang(int id) {
        iKhachHangRepository.deleteKhachHang(id);
    }

    @Override
    public void updateKhachHang(KhachHang khachHang) {
        iKhachHangRepository.updateKhachHang(khachHang);
    }

}
