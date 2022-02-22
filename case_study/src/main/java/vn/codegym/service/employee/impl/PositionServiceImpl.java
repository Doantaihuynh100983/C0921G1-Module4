package vn.codegym.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Position;
import vn.codegym.repository.employee.IPositionRepository;
import vn.codegym.service.employee.IPositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> getAllPosition() {
        return iPositionRepository.findAll();
    }
}
