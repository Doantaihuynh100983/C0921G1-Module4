package vn.codegym.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Service;

public interface IServiceService {
    Page<Service> getAllService(Pageable pageable);
    Service findbyIdService(Integer  id);
    void addNewService(Service service);
    void deleteService(Integer id);
}
