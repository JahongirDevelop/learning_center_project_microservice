package uz.pdp.studentservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.studentservice.dto.request.ApplicationCR;
import uz.pdp.studentservice.dto.request.StudentCR;
import uz.pdp.studentservice.dto.response.StudentResponse;
import uz.pdp.studentservice.service.StudentService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCR studentCR) {
        return ResponseEntity.status(200).body(studentService.create(studentCR));
    }

    @GetMapping("/getAll")
    public List<StudentResponse> getAll(){
        return studentService.getAll();
    }
}
