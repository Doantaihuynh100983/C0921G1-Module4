package vn.codegym.repository.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.ServiceType;

@Repository
@Transactional
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
