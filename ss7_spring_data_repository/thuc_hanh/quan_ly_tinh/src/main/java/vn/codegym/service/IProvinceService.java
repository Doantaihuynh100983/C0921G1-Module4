package vn.codegym.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Province;

import java.util.List;

public interface IProvinceService{
    List<Province> findAll();
    void save(Province province);
    Province findById(Long id);

}
