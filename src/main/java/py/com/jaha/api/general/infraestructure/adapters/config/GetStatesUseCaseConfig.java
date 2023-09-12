package py.com.jaha.api.general.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.general.domain.ports.in.GetStatesPort;
import py.com.jaha.api.general.domain.ports.out.StatesRepositoryPort;
import py.com.jaha.api.general.domain.usecases.states.GetStatesUseCase;

@Configuration
public class GetStatesUseCaseConfig {

    @Bean
    public GetStatesPort getStatesUseCase(StatesRepositoryPort statesRepositoryPort){
        return new GetStatesUseCase(statesRepositoryPort);
    }
}
