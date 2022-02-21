package vn.codegym.repository.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.RentType;

@Transactional
@Repository
public interface IRentypeRepository  extends JpaRepository<RentType , Integer> {

}
