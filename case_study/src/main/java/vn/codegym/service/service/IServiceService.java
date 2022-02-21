package vn.codegym.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Service;

import java.util.List;

public interface IServiceService {
    List<Service> getAllService();
    Service findbyIdService(Integer  id);
    void addNewService(Service service);
    void deleteService(Integer id);
}
