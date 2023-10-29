package uz.pdp.studentservice.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.studentservice.UserResponse;
import uz.pdp.studentservice.dto.UserCR;
import uz.pdp.studentservice.entity.StudentEntity;
import uz.pdp.studentservice.repository.StudentRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final String USER_SERVICE = "http://PRODUCT_SERVICE/api/v1/users";

//    public StudentResponse create(StudentCR productCR) {
//        StudentEntity productEntity = modelMapper.map(productCR, StudentEntity.class);
//        return modelMapper.map(productRepository.save(productEntity), StudentResponse.class);
//    }
public StudentEntity create(StudentEntity userCR) {
    UserResponse userResponse = getUser(userCR.getUserId());
    if(userResponse == null) {
        throw new RuntimeException("user not found");
    } else {
        StudentEntity mapped = modelMapper.map(userResponse, StudentEntity.class);
        System.out.println("mapped = " + mapped);
        StudentEntity map = modelMapper.map(studentRepository.save(mapped), StudentEntity.class);
        System.out.println("map = " + map);
        return map;
    }

}
    public UserResponse getUser(UUID productId) {
        return ApiService.getObject(USER_SERVICE + "/" + productId, UserResponse.class);
    }



}
