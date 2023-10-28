package uz.pdp.adminservice.service;

import org.springframework.web.client.RestTemplate;


public class ApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    public static <T> T getObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);

    }
}
