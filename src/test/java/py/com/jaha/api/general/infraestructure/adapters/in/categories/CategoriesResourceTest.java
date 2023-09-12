package py.com.jaha.api.general.infraestructure.adapters.in.categories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static py.com.jaha.api.general.constants.GlobalConstants.API_BASE;
import static py.com.jaha.api.general.constants.GlobalConstants.API_VERSION_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesResponse;
import py.com.jaha.api.general.domain.ports.in.GetCategoriesPort;
import py.com.jaha.api.general.infraestructure.adapters.config.GetCategoriesUseCaseConfig;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ImportAutoConfiguration(value = {
    RefreshAutoConfiguration.class,
    GetCategoriesUseCaseConfig.class
})
@WebMvcTest(CategoriesResource.class)
public class CategoriesResourceTest {

    private final String CATEGORIES_BASE_URL = "/" + API_BASE + "/general/" + API_VERSION_1 + "/categories";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GetCategoriesPort getCategoriesUseCase;

    @Test
    public void getCategories_success() throws Exception{
        HttpHeaders httpHeaders = new HttpHeaders();

        when(getCategoriesUseCase.execute(any())).thenReturn(buildGetCategoriesResponse());

        MockHttpServletResponse response = mvc.perform(get(CATEGORIES_BASE_URL)
                .accept(MediaType.APPLICATION_JSON)
                .headers(httpHeaders)
        ).andReturn().getResponse();
        
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    private GetCategoriesResponse buildGetCategoriesResponse() {
        return GetCategoriesResponse.builder().build();
    }
}