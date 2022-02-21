package vn.codegym.repository.contractdetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.AttachService;

@Repository
@Transactional
public interface IAttachServiceReposotory extends JpaRepository<AttachService,Integer> {
}
