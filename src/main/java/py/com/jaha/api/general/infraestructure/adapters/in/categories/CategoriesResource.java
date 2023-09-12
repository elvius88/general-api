package py.com.jaha.api.general.infraestructure.adapters.in.categories;

import static py.com.jaha.api.general.commons.ApiVersions.API_VERSION_V1;
import static py.com.jaha.api.general.constants.GlobalConstants.API_BASE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import py.com.jaha.api.general.config.exception.ApiError;
import py.com.jaha.api.general.config.exception.ApiException;
import py.com.jaha.api.general.commons.ApiResponse;
import py.com.jaha.api.general.commons.Filterable;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesResponse;
import py.com.jaha.api.general.domain.ports.in.GetCategoriesPort;
import py.com.jaha.api.general.infraestructure.adapters.mappers.CategoriesCommandMapper;

@RestController
@RequestMapping(value = "/" + API_BASE + "/general/" + API_VERSION_V1)
@Tag(name = "CategoriesResource")
@RequiredArgsConstructor
@Slf4j
public class CategoriesResource {

    private final GetCategoriesPort getCategoriesUseCase;

    @Filterable
    @Operation(summary = "Categories", description = "Get Categories")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetCategoriesResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetCategoriesResponse> getCategories(@RequestParam(required = false) String name) throws ApiException {
        return ApiResponse.of(getCategoriesUseCase.execute(CategoriesCommandMapper.INSTANCE.toCommand(name)));
    }
}
