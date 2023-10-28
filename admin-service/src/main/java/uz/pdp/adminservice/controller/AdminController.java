package uz.pdp.adminservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.adminservice.dto.response.UserResponse;
import uz.pdp.adminservice.service.AdminService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

//    @PostMapping
//    public StudentResponse create(@RequestBody StudentCR inventoryCR) {
//        return inventoryService.create(inventoryCR);
//    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable UUID id) {
        return adminService.getUser(id);
    }
}
