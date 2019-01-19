package Application;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

// Creation du JPA Repository basé sur Spring Data
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Operation findByType(String type);
    Operation findByIbansourceAndIbandest(String ibansource, String ibandest);
    Operation findByDate(Date date);
}