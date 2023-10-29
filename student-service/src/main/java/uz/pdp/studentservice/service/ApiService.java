package uz.pdp.studentservice.service;

import org.springframework.web.client.RestTemplate;


public class ApiService {
    private static final RestTemplate restTemplate = new RestTemplate();
    public static <T> T getObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);

    }
}
