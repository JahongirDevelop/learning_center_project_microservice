package uz.pdp.userservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.userservice.entity.UserEntity;

import java.util.UUID;
@Repository

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
