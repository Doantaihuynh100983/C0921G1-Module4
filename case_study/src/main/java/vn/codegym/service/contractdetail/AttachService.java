package vn.codegym.service.contractdetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.contractdetail.IAttachServiceReposotory;

import java.util.List;

@Service
public class AttachService implements IAttachServiceService{
    @Autowired
    private  IAttachServiceReposotory iAttachServiceReposotory;
    @Override
    public List<vn.codegym.model.AttachService> getAllAttachService() {
        return iAttachServiceReposotory.findAll();
    }
}
