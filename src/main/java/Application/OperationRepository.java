package Application;


import org.springframework.data.jpa.repository.JpaRepository;

// Creation du JPA Repository basé sur Spring Data
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Operation findByType(String type);
    Operation findByIbansourceAndIbandest(String ibansource, String ibandest);
}