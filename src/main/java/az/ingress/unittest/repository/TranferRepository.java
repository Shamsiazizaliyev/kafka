package az.ingress.unittest.repository;

import az.ingress.unittest.dto.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranferRepository extends JpaRepository<Transfer,Long> {
}
