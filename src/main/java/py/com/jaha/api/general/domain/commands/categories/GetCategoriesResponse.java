package py.com.jaha.api.general.domain.commands.categories;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import py.com.jaha.api.general.config.IdNameDto;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoriesResponse {

  List<GetCategoryResponse> categories;
}
