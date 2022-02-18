package vn.codegym.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Division;
import vn.codegym.repository.employee.IDivisionRepository;
import vn.codegym.service.employee.IDivisionService;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> getAllDivision() {
        return iDivisionRepository.findAll();
    }
}
