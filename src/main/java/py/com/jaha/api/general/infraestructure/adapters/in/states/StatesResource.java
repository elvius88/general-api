package py.com.jaha.api.general.infraestructure.adapters.in.states;

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
import py.com.jaha.api.general.domain.commands.states.GetStatesResponse;
import py.com.jaha.api.general.domain.ports.in.GetStatesPort;
import py.com.jaha.api.general.infraestructure.adapters.mappers.StatesCommandMapper;

@RestController
@RequestMapping(value = "/" + API_BASE + "/general/" + API_VERSION_V1)
@Tag(name = "StateResource")
@RequiredArgsConstructor
@Slf4j
public class StatesResource {

    private final GetStatesPort getStatesUseCase;

    @Filterable
    @Operation(summary = "States", description = "Get States")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetStatesResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @GetMapping("/states")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetStatesResponse> getStates(@RequestParam(required = false) String name) throws ApiException {
        return ApiResponse.of(getStatesUseCase.execute(StatesCommandMapper.INSTANCE.toCommand(name)));
    }
}
