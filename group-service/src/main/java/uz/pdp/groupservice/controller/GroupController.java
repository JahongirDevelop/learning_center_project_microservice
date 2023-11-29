package uz.pdp.groupservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.groupservice.dto.request.GroupCreateDTO;
import uz.pdp.groupservice.dto.request.UpdateGroupDto;
import uz.pdp.groupservice.dto.response.GroupResponse;
import uz.pdp.groupservice.entity.GroupEntity;
import uz.pdp.groupservice.service.GroupService;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<GroupResponse> create(@Valid @RequestBody GroupCreateDTO groupCreateDTO) {
        return ResponseEntity.status(200).body(groupService.create(groupCreateDTO));
    }

    @GetMapping("/{id}")
    public GroupResponse getGroup(@PathVariable UUID id){
        return groupService.findById(id);
    }



//    @PutMapping("/update{groupId}")
//    public ResponseEntity<GroupResponse> update(@PathVariable @NotNull UUID groupId,
//                                                @Valid @RequestBody UpdateGroupDto updateGroupDto){
//
//        return ResponseEntity.status(200).body(groupService.update(groupId, updateGroupDto));
//
//    }
//    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCR studentCR) {
//        return ResponseEntity.status(200).body(studentService.create(studentCR));
//    }

}
