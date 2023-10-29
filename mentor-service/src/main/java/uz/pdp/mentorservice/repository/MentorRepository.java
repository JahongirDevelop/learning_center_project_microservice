package uz.pdp.mentorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.mentorservice.entity.MentorEntity;

import java.util.UUID;

@Repository
public interface MentorRepository extends JpaRepository<MentorEntity, UUID> {

}
