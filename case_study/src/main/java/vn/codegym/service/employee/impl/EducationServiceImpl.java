package vn.codegym.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.EducationDegree;
import vn.codegym.repository.employee.IEducationRepository;
import vn.codegym.service.employee.IEducationService;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {
    @Autowired
    private IEducationRepository iEducationRepository;

    @Override
    public List<EducationDegree> getAllEducation() {
        return iEducationRepository.findAll();
    }
}
