package uz.pdp.attendanceservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.attendanceservice.entity.AttendanceEntity;
import uz.pdp.attendanceservice.service.AttendanceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendances")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/create")
    public ResponseEntity<AttendanceEntity> create(@Valid @RequestBody AttendanceEntity attendance){
        return ResponseEntity.status(200).body(attendanceService.create(attendance));
    }

    @GetMapping("get-student/{id}")
    public List<AttendanceEntity> getStudentAttendances(
            @PathVariable UUID id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {
        return attendanceService.getStudentAttendances(id, page, size);
    }

}
