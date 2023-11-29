package uz.pdp.groupservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.groupservice.dto.request.GroupCreateDTO;
import uz.pdp.groupservice.dto.request.UpdateGroupDto;
import uz.pdp.groupservice.dto.response.CourseResponse;
import uz.pdp.groupservice.dto.response.GroupResponse;
import uz.pdp.groupservice.dto.response.MentorResponse;
import uz.pdp.groupservice.entity.*;
import uz.pdp.groupservice.exception.DataNotFoundException;
import uz.pdp.groupservice.exception.DuplicateValueException;
import uz.pdp.groupservice.repository.GroupRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;
    private final ApiService apiService;
    private final String COURSE_SERVICE = "http://COURSE-SERVICE/api/v1/courses";
    private final String MENTOR_SERVICE = "http://MENTOR-SERVICE/api/v1/mentors";
    public GroupResponse create(GroupCreateDTO dto) {
        if (groupRepository.existsByGroupName(dto.getGroupName())) {
            throw new DuplicateValueException("This group already exists with name '" + dto.getGroupName() + "'");
        }
        if(getCourse(dto.getCourseId()) == null) {
            throw new DataNotFoundException("this course not found");
        }
        if(getMentor(dto.getMentorId()) == null) {
            throw new DataNotFoundException("this mentor not found");
        }

        GroupResponse group = new GroupResponse();
        group.setGroupName(dto.getGroupName());
        group.setStudentCount(20);
        group.setCourseId(dto.getCourseId());
        System.out.println("group.getCourseId() = " + group.getCourseId());
        group.setMentorId(dto.getMentorId());
        group.setStatus(GroupStatus.CREATED);
        groupRepository.save(modelMapper.map(group, GroupEntity.class));
        return group;
    }
    public GroupResponse findById(UUID id) {
        return modelMapper.map(groupRepository.findById(id), GroupResponse.class);
    }

    public GroupResponse update(UUID groupId, UpdateGroupDto updateGroupDto) {
        GroupEntity group = groupRepository.findById(groupId).orElseThrow(
                () -> new DataNotFoundException("group not found"));
        modelMapper.map(updateGroupDto, group);
        groupRepository.save(group);
         return modelMapper.map(group, GroupResponse.class);
    }

    public List<GroupEntity> getAll(){
        return groupRepository.findAll();
    }


    public CourseResponse getCourse(UUID id) {
        return apiService.getObject(COURSE_SERVICE + "/" + id, CourseResponse.class);
    }
    public MentorResponse getMentor(UUID id) {
        return apiService.getObject(MENTOR_SERVICE + "/" + id, MentorResponse.class);
    }


}
