package uz.pdp.adminservice.service;

import org.springframework.stereotype.Service;
import uz.pdp.adminservice.dto.response.UserResponse;

import java.util.UUID;

@Service
public class AdminService {
    private final String USER_SERVICE = "http://USER_SERVICE/api/v1/users";
    public UserResponse getUser(UUID userId) {
        return ApiService.getObject(USER_SERVICE + "/" + userId, UserResponse.class);
    }
}
