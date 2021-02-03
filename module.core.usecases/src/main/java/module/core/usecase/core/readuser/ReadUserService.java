package module.core.usecase.core.readuser;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import module.core.usecase.core.UserBuilder;
import module.core.usecase.gateways.UserDataProvider;
import module.core.usecase.ports.ReadUser;
import module.core.usecase.ports.model.UserDto;

@RequiredArgsConstructor
public class ReadUserService implements ReadUser {

    private final UserBuilder builder;
    private final UserDataProvider userDataProvider;

    @Override
    public UserDto searchUser(String id) {
        return userDataProvider.findUser(id)
                .map(builder::buildDto)
                .orElse(UserDto.builder().build());
    }

    @Override
    public List<UserDto> searchUsers() {
        return userDataProvider.findAllUsers().stream()
                .map(builder::buildDto)
                .collect(Collectors.toList());
    }
}
