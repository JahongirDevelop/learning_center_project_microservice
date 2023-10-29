package uz.pdp.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.userservice.dto.request.UserCR;
import uz.pdp.userservice.dto.response.UserResponse;
import uz.pdp.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    public UserResponse create(@RequestBody UserCR userCR) {
        return userService.create(userCR);
    }
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable UUID id) {
        return userService.findByID(id);
    }
}
