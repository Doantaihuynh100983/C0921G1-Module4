package vn.codegym.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.RentType;
import vn.codegym.repository.service.IRentypeRepository;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService{
    @Autowired
    IRentypeRepository iRentypeRepository;
    @Override
    public List<RentType> getAllRentType() {
        return iRentypeRepository.findAll();
    }
}
