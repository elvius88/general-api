package py.com.jaha.api.general.infraestructure.adapters.in.cities;

import static py.com.jaha.api.general.constants.GlobalConstants.API_BASE;
import static py.com.jaha.api.general.commons.ApiVersions.API_VERSION_V1;

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
import py.com.jaha.api.general.domain.commands.cities.GetCitiesResponse;
import py.com.jaha.api.general.domain.ports.in.GetCitiesPort;
import py.com.jaha.api.general.config.exception.ApiError;
import py.com.jaha.api.general.config.exception.ApiException;
import py.com.jaha.api.general.commons.ApiResponse;
import py.com.jaha.api.general.infraestructure.adapters.mappers.CitiesCommandMapper;

@RestController
@RequestMapping(value = "/" + API_BASE + "/general/" + API_VERSION_V1)
@Tag(name = "CityResource")
@RequiredArgsConstructor
@Slf4j
public class CitiesResource {

    private final GetCitiesPort getCitiesUseCase;

    @Operation(summary = "Cities", description = "Get Cities")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetCitiesResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetCitiesResponse> getCities(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String state) throws ApiException {
        return ApiResponse.of(getCitiesUseCase.execute(CitiesCommandMapper.INSTANCE.toCommand(name, state)));
    }
}
