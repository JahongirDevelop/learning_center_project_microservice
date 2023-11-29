package uz.pdp.attendanceservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.attendanceservice.entity.AttendanceEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, UUID> {
//    List<AttendanceEntity> findAllByStudentId(UUID id);
    Page<AttendanceEntity> findAllByStudentId(Pageable pageable, UUID id);
}
