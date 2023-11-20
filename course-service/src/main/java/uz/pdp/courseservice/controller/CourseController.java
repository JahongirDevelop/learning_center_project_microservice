package uz.pdp.courseservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import uz.pdp.courseservice.dto.request.CourseCreateDTO;
import uz.pdp.courseservice.dto.response.CourseResponse;
import uz.pdp.courseservice.entity.CourseEntity;
import uz.pdp.courseservice.service.CourseService;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;



    @PostMapping("/create")
    public ResponseEntity<CourseEntity> create(@RequestBody @Valid CourseCreateDTO courseCreateDTO) {
        return ResponseEntity.status(200).body(courseService.create(courseCreateDTO));

    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseResponse findById(@PathVariable UUID id) {
        return courseService.findById(id);
    }


//    @PutMapping
//    public ResponseEntity<CourseEntity> updateCourse(
//            @RequestBody @Valid CourseUpdateDTO courseUpdateDTO
//    ) {
//        CourseEntity courseEntity = courseService.updateCourse(courseUpdateDTO);
//        return ResponseEntity.ok(new ResponseDTO<>(courseEntity));
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CourseEntity> getById(@PathVariable Long id) {
//        CourseEntity courseEntity = courseService.getById(id);
//        return ResponseEntity.ok(new ResponseDTO<>(courseEntity));
//    }
//
//
//    @GetMapping("/all-courses")
//    public ResponseEntity<List<CourseEtity>>> getAllCourses() {
//        List<CourseEntity> coursesList = courseService.getAll();
//        return ResponseEntity.ok(new ResponseDTO<>(coursesList));
//    }
//
//
//    @GetMapping("/all-deleted")
//    public ResponseEntity<List<CourseEtity>>> getAllDeletedList() {
//        List<CourseEntity> allDeletedList = courseService.getAllDeletedList();
//        return ResponseEntity.ok(new ResponseDTO<>(allDeletedList));
//    }
//
//
//    @GetMapping("/teacher-courses/{teacherId}")
//    public ResponseEntity<List<CourseEtity>>> getTeacherCourses(
//            @PathVariable Long teacherId
//    ) {
//        List<CourseEntity> teacherCourses = courseService.getTeacherCourses(teacherId);
//        return ResponseEntity.ok(new ResponseDTO<>(teacherCourses));
//    }
//
//
//    @PostMapping("/add-teacher-to-course")
//    public ResponseEntity<String>> addeacherToCourse(
//            @Valid @RequestBody CourseTeacherDTO courseTeacherDTO
//    ) {
//        courseService.addTeacherToCourse(courseTeacherDTO);
//        return ResponseEntity.ok(new ResponseDTO<>("success"));
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String>> delteById(@PathVariable Long id) {
//        courseService.deleteById(id);
//        return ResponseEntity.ok(new ResponseDTO<>("Success"));
//    }

}
