package vn.codegym.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.repository.customer.ICustomerTypeRepository;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    ICustomerTypeRepository iCustomerTypeService;

    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerTypeService.findAll();
    }
}
