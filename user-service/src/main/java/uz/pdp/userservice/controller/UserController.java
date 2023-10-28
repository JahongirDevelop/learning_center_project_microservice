package uz.pdp.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.userservice.dto.response.UserResponse;
import uz.pdp.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable UUID id) {
        return userService.findByID(id);
    }
}
