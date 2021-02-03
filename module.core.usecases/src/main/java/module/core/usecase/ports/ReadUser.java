package module.core.usecase.ports;

import java.util.List;

import module.core.usecase.ports.model.UserDto;

public interface ReadUser {

    UserDto searchUser(String id);

    List<UserDto> searchUsers();
}
