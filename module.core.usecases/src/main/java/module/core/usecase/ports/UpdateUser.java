package module.core.usecase.ports;

import module.core.usecase.ports.model.UserDto;

public interface UpdateUser {

    UserDto updateUser(UserDto userDto);
}
