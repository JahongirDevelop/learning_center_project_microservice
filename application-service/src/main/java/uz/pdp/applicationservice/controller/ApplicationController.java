package uz.pdp.applicationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.applicationservice.dto.request.ApplicationCR;
import uz.pdp.applicationservice.dto.response.ApplicationResponse;
import uz.pdp.applicationservice.entity.ApplicationEntity;
import uz.pdp.applicationservice.service.ApplicationService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/create")
    public ApplicationResponse create(@RequestBody ApplicationCR applicationCR){
        return applicationService.create(applicationCR);
    }
    @GetMapping("/get-application/{id}")
    public ApplicationResponse getApplication(@PathVariable UUID id){
        return applicationService.findById(id);
    }


    // add status, and related methods
}
