package uz.pdp.applicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.applicationservice.entity.ApplicationEntity;

import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, UUID> {


}
