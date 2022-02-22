package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.repository.customer.ICustomerTypeRepository;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private  ICustomerTypeRepository iCustomerTypeService;

    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerTypeService.findAll();
    }
}
