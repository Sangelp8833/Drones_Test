package co.com.bancolombia.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean(name = "ModelMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
