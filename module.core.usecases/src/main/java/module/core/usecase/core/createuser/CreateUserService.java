package module.core.usecase.core.createuser;

import lombok.RequiredArgsConstructor;

import module.core.entity.User;
import module.core.usecase.core.UserBuilder;
import module.core.usecase.gateways.UserDataProvider;
import module.core.usecase.ports.CreateUser;
import module.core.usecase.ports.model.UserDto;

@RequiredArgsConstructor
public class CreateUserService implements CreateUser {

    private final UserBuilder builder;
    private final UserDataProvider userDataProvider;

    @Override
    public UserDto crateUser(UserDto dto) {
        User user = userDataProvider.createUser(builder.buildUser(dto));
        return builder.buildDto(user);
    }
}
