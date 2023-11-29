package uz.pdp.studentservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.studentservice.dto.request.ApplicationCR;
import uz.pdp.studentservice.dto.response.GroupResponse;
import uz.pdp.studentservice.dto.response.StudentResponse;
import uz.pdp.studentservice.dto.response.ApplicationResponse;
import uz.pdp.studentservice.entity.StudentEntity;
import uz.pdp.studentservice.exception.DataAlreadyExistsException;
import uz.pdp.studentservice.exception.DataNotFoundException;
import uz.pdp.studentservice.repository.StudentRepository;
import uz.pdp.studentservice.dto.request.StudentCR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;




@Service
@RequiredArgsConstructor
public class StudentService {
    private final ApiService apiService;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final String APPLICATION_SERVICE = "http://APPLICATION-SERVICE/api/v1/applications";
    private final String GROUP_SERVICE = "http://GROUP-SERVICE/api/v1/groups";
    private final MailSenderService senderService;


    public StudentResponse create(StudentCR  studentCR) {

        ApplicationResponse application = getApplication(studentCR.getApplicationId());
        if (application == null) {
            throw new DataNotFoundException("application not found");
        }
        GroupResponse groupResponse = getGroup(studentCR.getGroupId());
        if (groupResponse == null) {
            throw new DataNotFoundException("group not found");
        }
        else {
            Random random = new Random();
            String verificationCode = String.valueOf(random.nextInt(90000) + 10000);
            senderService.sendVerificationCode(studentCR.getEmail(),verificationCode);
            StudentEntity studentEntity = StudentEntity.builder()
                    .applicationId(studentCR.getApplicationId())
                    .name(studentCR.getName())
                    .surname(studentCR.getSurname())
                    .phoneNumber(studentCR.getPhoneNumber())
                    .email(studentCR.getEmail())
                    .rating(0)
                    .password(verificationCode)
                    .groupId(studentCR.getGroupId())
                    .build();

            studentRepository.save(studentEntity);
            return modelMapper.map(studentEntity, StudentResponse.class);

        }

    }

    public List<StudentResponse> getAll() {
//        List<StudentResponse> studentResponses = new ArrayList<>();
//
//        List<StudentEntity> all = studentRepository.findAll();
//        for (StudentEntity studentEntity : all) {
//            StudentResponse studentResponse = new StudentResponse();
//            ApplicationResponse application = getApplication(studentEntity.getApplicationId());
//            StudentEntity studentEntityByApplicationId = getByApplicationId(studentEntity.getApplicationId());
//            studentResponse.setName(application.getName());
//            studentResponse.setSurname(application.getSurname());
//            studentResponse.setPhoneNumber(application.getPhoneNumber());
//            studentResponse.setEmail(application.getEmail());
//            studentResponse.setRating(studentEntityByApplicationId.getRating());
////            studentResponse.setApplicationId(studentEntityByApplicationId.getApplicationId());
//            studentResponses.add(studentResponse);
//        }
        return null;
    }

    private StudentEntity getByApplicationId(UUID applicationId) {
        return studentRepository.findStudentEntityByApplicationId(applicationId).orElseThrow(
                () -> new DataNotFoundException("application not found" + applicationId));
    }

    public ApplicationResponse getApplication(UUID id) {
        return apiService.getObject(APPLICATION_SERVICE + "/" + id, ApplicationResponse.class);
    }
    public GroupResponse getGroup(UUID id) {
        return apiService.getObject(GROUP_SERVICE + "/" + id, GroupResponse.class);
    }

}
