package uz.pdp.lessonservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.lessonservice.dto.request.LessonCR;
import uz.pdp.lessonservice.dto.response.LessonResponse;
import uz.pdp.lessonservice.entity.LessonEntity;
import uz.pdp.lessonservice.repository.LessonRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;

    public LessonResponse create(LessonCR lessonCR) {
        LessonEntity lessonEntity = modelMapper.map(lessonCR, LessonEntity.class);
        return modelMapper.map(lessonRepository.save(lessonEntity),LessonResponse.class);
    }

    public List<LessonResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<LessonEntity> productEntities = lessonRepository.findAll(pageable).getContent();
        return modelMapper.map(productEntities, new TypeToken<List<LessonResponse>>(){}.getType());
    }


    public LessonResponse findById(UUID id) {
        return modelMapper.map(lessonRepository.findById(id).get(), LessonResponse.class);
    }

    public List<LessonEntity> getLesson(UUID groupId) {
        return lessonRepository.findLessonsByGroupId(groupId);
    }
}
