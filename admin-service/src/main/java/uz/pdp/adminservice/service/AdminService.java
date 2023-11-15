package uz.pdp.adminservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.adminservice.dto.response.ApplicationResponse;
import uz.pdp.adminservice.dto.response.UserResponse;
import uz.pdp.adminservice.entity.ApplicationEntity;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final RestTemplate restTemplate ;
    private final ApiService apiService;
    private final String USER_SERVICE = "http://USER_SERVICE/api/v1/users";
    private final String APPLICATION_SERVICE = "http://localhost:8089/";
    private final String REGION_SERVICE = "http://localhost:8089";
//    public UserResponse getUser(UUID userId) {
//        return apiService.getObject(USER_SERVICE + "/" + userId, UserResponse.class);
//    }
    public UserResponse getUser(UUID userId) {
        ResponseEntity<UserResponse> exchange =
                restTemplate.exchange(  "http://localhost:8088/api/v1/users/" + userId,
                HttpMethod.GET,
                null,
                UserResponse.class);
        return exchange.getBody();
        //return apiService.getObject(USER_SERVICE + "/" + userId, UserResponse.class);
    }
    public ApplicationResponse getApplication(UUID id) {
      return  restTemplate.exchange(  APPLICATION_SERVICE+"api/v1/applications/get-application/" + id,
                HttpMethod.GET,
                null,
                ApplicationResponse.class).getBody();
    }




}
