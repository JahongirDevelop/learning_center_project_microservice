package uz.pdp.mentorservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.mentorservice.dto.request.MentorCR;
import uz.pdp.mentorservice.dto.response.MentorResponse;
import uz.pdp.mentorservice.service.MentorService;


import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentors")
public class MentorController {
    private final MentorService mentorService;

    @PostMapping("/create")
    public MentorResponse create(@RequestBody MentorCR productCR) {
        return mentorService.create(productCR);
    }

    @GetMapping("/create")
    public List<MentorResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return mentorService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public MentorResponse findById(@PathVariable UUID id) {
        return mentorService.findById(id);
    }
}
