package uz.pdp.userservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.userservice.dto.request.UserCR;
import uz.pdp.userservice.dto.response.UserResponse;
import uz.pdp.userservice.entity.UserEntity;
import uz.pdp.userservice.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponse create(UserCR userCR) {
        UserEntity userEntity = modelMapper.map(userCR, UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), UserResponse.class);
    }
    public UserResponse findByID(UUID id) {
        return modelMapper.map(userRepository.findById(id).get(), UserResponse.class);
    }
}
