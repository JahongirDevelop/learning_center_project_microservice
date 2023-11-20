package uz.pdp.groupservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.groupservice.dto.request.GroupCreateDTO;
import uz.pdp.groupservice.dto.response.GroupResponse;
import uz.pdp.groupservice.entity.GroupEntity;
import uz.pdp.groupservice.service.GroupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<GroupResponse> create(@Valid @RequestBody GroupCreateDTO groupCreateDTO) {
        return ResponseEntity.status(200).body(groupService.create(groupCreateDTO));
    }

//    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCR studentCR) {
//        return ResponseEntity.status(200).body(studentService.create(studentCR));
//    }

}
