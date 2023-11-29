package uz.pdp.attendanceservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ApiService {
    private final RestTemplate restTemplate;

//    private static final RestTemplate restTemplate = new RestTemplate();

    public <T> T getObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }
}
