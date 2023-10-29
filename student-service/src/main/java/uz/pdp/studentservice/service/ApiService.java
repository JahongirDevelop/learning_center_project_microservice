package uz.pdp.studentservice.service;

import org.springframework.web.client.RestTemplate;


public class ApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    public <T> T getObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);

    }
}
