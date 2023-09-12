package py.com.jaha.api.general.domain.commands.cities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCitiesCommand {

  private String name;
  private String state;
}
