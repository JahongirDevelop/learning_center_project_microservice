package uz.pdp.lessonservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lessonservice.dto.request.LessonCR;
import uz.pdp.lessonservice.dto.response.LessonResponse;
import uz.pdp.lessonservice.service.LessonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lessons")
public class LessonController {
    private final LessonService lessonService;
    @PostMapping
    public LessonResponse create(@RequestBody LessonCR lessonCR){
        return  lessonService.create(lessonCR);
    }
    @GetMapping
    public List<LessonResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return lessonService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public LessonResponse findById(@PathVariable UUID id) {
        return lessonService.findById(id);
    }


}
