package py.com.jaha.api.general.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.general.domain.ports.in.GetCategoriesPort;
import py.com.jaha.api.general.domain.ports.out.CategoriesRepositoryPort;
import py.com.jaha.api.general.domain.usecases.categories.GetCategoriesUseCase;

@Configuration
public class GetCategoriesUseCaseConfig {

    @Bean
    public GetCategoriesPort getCategoriesUseCase(CategoriesRepositoryPort categoriesRepositoryPort){
        return new GetCategoriesUseCase(categoriesRepositoryPort);
    }
}
