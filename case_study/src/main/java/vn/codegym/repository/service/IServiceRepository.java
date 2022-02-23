package vn.codegym.repository.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Customer;
import vn.codegym.model.Service;

@Repository
@Transactional
public interface IServiceRepository extends JpaRepository<Service, Integer> {
    @Modifying
    @Query(value = "UPDATE service SET flag_delete_service = 0 WHERE  service_id = :service_id " ,nativeQuery=true)
    void deleteByServiceId(@Param("service_id") Integer id);

    @Query(value="select * from Service where service_name like %:serviceName% and rent_type_id like %:rentType%  and service_type_id like %:serviceType%  and flag_delete_service = 1" ,nativeQuery=true)
    Page<Service> searchService(@Param("serviceName") String serviceName,
                                  @Param("rentType") String rentType,
                                  @Param("serviceType") String serviceType,
                                  Pageable pageable);
}
