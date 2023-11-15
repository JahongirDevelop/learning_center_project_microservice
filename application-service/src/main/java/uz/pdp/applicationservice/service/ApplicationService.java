package uz.pdp.applicationservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.applicationservice.dto.request.ApplicationCR;
import uz.pdp.applicationservice.dto.response.ApplicationResponse;
import uz.pdp.applicationservice.entity.ApplicationEntity;
import uz.pdp.applicationservice.repository.ApplicationRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationService {
  private final ApplicationRepository applicationRepository;

    private final ModelMapper modelMapper;

    public ApplicationResponse create(ApplicationCR applicationCR) {
        ApplicationEntity applicationEntity = modelMapper.map(applicationCR, ApplicationEntity.class);
        return modelMapper.map(applicationRepository.save(applicationEntity), ApplicationResponse.class);
    }
    public List<ApplicationResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<ApplicationEntity> applications = applicationRepository.findAll(pageable).getContent();
        return modelMapper.map(applications, new TypeToken<List<ApplicationResponse>>(){}.getType());
    }
    public ApplicationResponse findById(UUID id) {
        return modelMapper.map(applicationRepository.findById(id), ApplicationResponse.class);
    }
}
