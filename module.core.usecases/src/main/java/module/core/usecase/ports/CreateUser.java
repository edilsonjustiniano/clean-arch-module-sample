package module.core.usecase.ports;

import module.core.usecase.ports.model.UserDto;

public interface CreateUser {

    UserDto crateUser(UserDto userDto);
}
