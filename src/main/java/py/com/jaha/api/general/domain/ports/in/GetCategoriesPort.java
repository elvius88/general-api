package py.com.jaha.api.general.domain.ports.in;

import py.com.jaha.api.general.domain.commands.categories.GetCategoriesCommand;
import py.com.jaha.api.general.domain.commands.categories.GetCategoriesResponse;
import py.com.jaha.api.general.domain.usecases.UseCase;

public interface GetCategoriesPort extends UseCase<GetCategoriesResponse, GetCategoriesCommand> {
}
