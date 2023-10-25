package uz.pdp.mentorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class MentorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentorServiceApplication.class, args);
    }

}
