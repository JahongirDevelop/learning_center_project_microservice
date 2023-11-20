package uz.pdp.studentservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.studentservice.dto.response.StudentResponse;
import uz.pdp.studentservice.dto.response.UserResponse;
import uz.pdp.studentservice.entity.StudentEntity;
import uz.pdp.studentservice.exception.DataAlreadyExistsException;
import uz.pdp.studentservice.exception.DataNotFoundException;
import uz.pdp.studentservice.repository.StudentRepository;
import uz.pdp.studentservice.dto.request.StudentCR;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static uz.pdp.studentservice.entity.UserRole.STUDENT;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ApiService apiService;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final String USER_SERVICE = "http://USER-SERVICE/api/v1/users";


    public StudentResponse create(StudentCR userCR) {
        UserResponse userResponse = getUser(userCR.getUserId());
        if (userResponse == null) {
            throw new DataNotFoundException("user not found");
        } else {

            if(studentRepository.existsByUserId((userCR.getUserId()))) {
                throw new DataAlreadyExistsException("user already exits "+ userCR.getUserId());
            }
            StudentEntity studentEntity = StudentEntity.builder()
                    .userId(userCR.getUserId())
                    .rating(userCR.getRating())
                    .build();
            studentRepository.save(studentEntity);
            StudentResponse studentResponse = StudentResponse.builder()
                    .userId(userCR.getUserId())
                    .email(userResponse.getEmail())
                    .name(userResponse.getName())
                    .phoneNumber(userResponse.getPhoneNumber())
                    .rating(userCR.getRating())
                    .role(STUDENT)
                    .surName(userResponse.getSurName())
                    .build();
            return studentResponse;
        }

    }

    public List<StudentResponse> getAll() {
        List<StudentResponse> studentResponses = new ArrayList<>();

        List<StudentEntity> all = studentRepository.findAll();
        for (StudentEntity studentEntity : all) {
            StudentResponse studentResponse = new StudentResponse();
            UserResponse user = getUser(studentEntity.getUserId());
            StudentEntity studentEntityByUserId = getByUserId(studentEntity.getUserId());
            studentResponse.setName(user.getName());
            studentResponse.setSurName(user.getSurName());
            studentResponse.setPhoneNumber(user.getPhoneNumber());
            studentResponse.setEmail(user.getEmail());
            studentResponse.setRole(user.getRole());
            studentResponse.setRating(studentEntityByUserId.getRating());
            studentResponse.setUserId(studentEntityByUserId.getUserId());
            studentResponses.add(studentResponse);
        }
        return studentResponses;
    }

    private StudentEntity getByUserId(UUID userId) {
        return studentRepository.findStudentEntityByUserId(userId).orElseThrow(
                () -> new DataNotFoundException("user not found" + userId));
    }

    public UserResponse getUser(UUID id) {
        return apiService.getObject(USER_SERVICE + "/" + id, UserResponse.class);
    }

}
