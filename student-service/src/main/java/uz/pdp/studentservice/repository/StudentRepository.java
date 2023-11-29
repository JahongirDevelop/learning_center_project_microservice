package uz.pdp.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.studentservice.entity.StudentEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    Optional<StudentEntity> findStudentEntityByApplicationId(UUID id);

    @Query("SELECT CASE WHEN COUNT(se) > 0 THEN true ELSE false END FROM StudentEntity se WHERE se.applicationId = :applicationId")
    boolean existsByApplicationId(@Param("applicationId") UUID applicationId);

}
