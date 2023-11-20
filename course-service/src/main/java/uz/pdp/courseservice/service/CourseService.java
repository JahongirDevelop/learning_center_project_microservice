package uz.pdp.courseservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.courseservice.dto.request.CourseCreateDTO;
import uz.pdp.courseservice.dto.response.CourseResponse;
import uz.pdp.courseservice.entity.CourseEntity;
import uz.pdp.courseservice.exception.DataNotFoundException;
import uz.pdp.courseservice.exception.DuplicateValueException;
import uz.pdp.courseservice.repository.CourseRepository;


import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

//    private final UserService userService;
    private final ModelMapper modelMapper;


    public CourseEntity create(CourseCreateDTO createDTO) {
        if (courseRepository.existsByName(createDTO.getName()))
            throw new DuplicateValueException("This course already exists");
        return courseRepository.save(modelMapper.map(createDTO, CourseEntity.class));
    }


//    public CourseEntity updateCourse(CourseUpdateDTO updateDTO) {
//        return courseRepository.save(COURSE_MAPPER.partialUpdate(updateDTO, getCourseById(updateDTO.id())));
//    }


    public CourseResponse findById(UUID id) {
        return modelMapper.map(courseRepository.findById(id).get(), CourseResponse.class);
    }

    public List<CourseEntity> getAll() {
        return courseRepository.findAll();
    }


//    public List<CourseEntity> getAllDeletedList() {
//        return courseRepository.findAllDeletedCourses();
//    }


//    public List<CourseEntity> getTeacherCourses(Long teacherId) {
//        UserEntity teacher = userService.getById(teacherId);
//        if (!Objects.equals(teacher.getRole(), Role.TEACHER))
//            throw new BadRequestException("User has not TEACHER role");
//        return courseRepository.findCoursesByTeacherId(teacherId);
//    }


//    public void deleteById(Long id) {
//        CourseEntity courseEntity = getCourseById(id);
//        courseEntity.setDeleted(true);
//        courseRepository.save(courseEntity);
//    }


//    public void addTeacherToCourse(CourseTeacherDTO dto) {
//        CourseEntity courseEntity = getCourseById(dto.courseID());
//        UserEntity teacher = userService.getById(dto.teacherID());
//        if (!Objects.equals(teacher.getRole(), Role.TEACHER))
//            throw new BadRequestException("User has not TEACHER role");
//        courseEntity.getTeachers().add(teacher);
//        courseRepository.save(courseEntity);
//    }


    private CourseResponse getCourseById(UUID id) {
        CourseEntity courseNotFound = courseRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Course not found")
        );
        return modelMapper.map(courseNotFound, CourseResponse.class);
    }
}
