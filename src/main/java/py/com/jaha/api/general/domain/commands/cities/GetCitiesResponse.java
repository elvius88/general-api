package py.com.jaha.api.general.domain.commands.cities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.com.jaha.api.general.config.IdNameDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCitiesResponse {

  List<IdNameDto<String, String>> cities;
}
