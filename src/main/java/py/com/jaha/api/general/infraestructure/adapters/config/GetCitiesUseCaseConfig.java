package py.com.jaha.api.general.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.general.domain.ports.in.GetCitiesPort;
import py.com.jaha.api.general.domain.ports.out.CitiesRepositoryPort;
import py.com.jaha.api.general.domain.usecases.cities.GetCitiesUseCase;

@Configuration
public class GetCitiesUseCaseConfig {

    @Bean
    public GetCitiesPort getCitiesUseCase(CitiesRepositoryPort citiesRepositoryPort){
        return new GetCitiesUseCase(citiesRepositoryPort);
    }
}
