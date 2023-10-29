package uz.pdp.lessonservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }
}
