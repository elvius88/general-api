package py.com.jaha.api.general.commons;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import py.com.jaha.api.general.config.CustomPageable;
import py.com.jaha.api.general.infraestructure.adapters.in.cities.CitiesResource;

@Component
public class PageableComponent {

    @CustomPageable(CitiesResource.class)
    public <T> ApiPageableResponse<T> pageableOfferResource(Page<T> page) {
        return ApiPageableResponse.of(page.getContent());
    }

    @CustomPageable(CitiesResource.class)
    public <T> ApiPageableResponse<T> pageableTermsAndConditionsAdminResource(Page<T> page) {
        var pagination = new CustomPagination();
        pagination.setPage(page.getNumber());
        pagination.setPageSize(page.getSize());
        pagination.setTotalElements(page.getTotalElements());
        pagination.setTotalPages(page.getTotalPages());
        var response = ApiPageableResponse.of(page.getContent());
        response.setPagination(pagination);
        return ApiPageableResponse.of(page.getContent());
    }
}
