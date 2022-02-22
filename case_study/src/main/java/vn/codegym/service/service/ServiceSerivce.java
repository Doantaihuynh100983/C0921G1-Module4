package vn.codegym.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.repository.service.IServiceRepository;

import java.util.List;

@Service
public class ServiceSerivce implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public List<vn.codegym.model.Service> getAllService() {
        return iServiceRepository.findAll();
    }

    @Override
    public vn.codegym.model.Service findbyIdService(Integer id) {
        return iServiceRepository.findById(id).orElse(new vn.codegym.model.Service());
    }

    @Override
    public void addNewService(vn.codegym.model.Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void deleteService(Integer id) {
        iServiceRepository.deleteByServiceId(id);
    }
}
