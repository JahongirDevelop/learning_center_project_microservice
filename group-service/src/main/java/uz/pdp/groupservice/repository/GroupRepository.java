package uz.pdp.groupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.groupservice.entity.GroupEntity;

import java.util.UUID;
@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {
    boolean existsByGroupName(String groupName);

}
