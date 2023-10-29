package uz.pdp.mentorservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.mentorservice.dto.request.MentorCR;
import uz.pdp.mentorservice.dto.response.MentorResponse;
import uz.pdp.mentorservice.entity.MentorEntity;
import uz.pdp.mentorservice.repository.MentorRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MentorService {

     private final MentorRepository mentorRepository;
     private final ModelMapper modelMapper;

    public MentorResponse create(MentorCR productCR) {
        MentorEntity mentorEntity = modelMapper.map(productCR, MentorEntity.class);
        return modelMapper.map(mentorRepository.save(mentorEntity), MentorResponse.class);
    }

    public List<MentorResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<MentorEntity> productEntities = mentorRepository.findAll(pageable).getContent();
        return modelMapper.map(productEntities, new TypeToken<List<MentorResponse>>(){}.getType());

    }

    public MentorResponse findById(UUID id) {

        return modelMapper.map(mentorRepository.findById(id).get(), MentorResponse.class);
    }
}
