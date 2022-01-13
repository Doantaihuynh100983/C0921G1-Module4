package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.IMedicalRepository;

import java.util.List;

@Service
public class MedicalService implements IMedicalService{
    @Autowired
    IMedicalRepository iMedicalRepository;
    @Override
    public List<String> quocTich() {
        return iMedicalRepository.quocTich();
    }

    @Override
    public List<String> thongTinDiLai() {
        return iMedicalRepository.thongTinDiLai();
    }

    @Override
    public List<String> tinhThanh() {
        return iMedicalRepository.tinhThanh();
    }

    @Override
    public List<String> quanHuyen() {
        return iMedicalRepository.quanHuyen();
    }

    @Override
    public List<String> phuongXa() {
        return  iMedicalRepository.phuongXa();
    }

    @Override
    public List<String> trieuCHung() {
        return iMedicalRepository.trieuCHung();
    }
}
