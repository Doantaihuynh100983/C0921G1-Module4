package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Province;
import vn.codegym.repository.IProvinceRepository;
import vn.codegym.service.IProvinceService;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public Province findById(Long id) {
        return  iProvinceRepository.findById(id).orElse(new Province());
    }
}
