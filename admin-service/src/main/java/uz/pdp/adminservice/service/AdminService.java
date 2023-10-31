package uz.pdp.adminservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.adminservice.dto.response.UserResponse;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final ApiService apiService;
    private final String USER_SERVICE = "http://USER_SERVICE/api/v1/users";
    public UserResponse getUser(UUID userId) {
        return apiService.getObject(USER_SERVICE + "/" + userId, UserResponse.class);
    }
}
