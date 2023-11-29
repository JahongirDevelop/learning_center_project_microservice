package uz.pdp.attendanceservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.attendanceservice.entity.AttendanceEntity;
import uz.pdp.attendanceservice.repository.AttendanceRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final ModelMapper modelMapper;
    private final AttendanceRepository attendanceRepository;
    public AttendanceEntity create(AttendanceEntity attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<AttendanceEntity> getStudentAttendances(UUID id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return attendanceRepository.findAllByStudentId(pageable, id).getContent();

    }
}
