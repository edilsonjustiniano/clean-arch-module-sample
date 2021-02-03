package module.delivery.rest.impl;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import module.core.usecase.ports.CreateUser;
import module.core.usecase.ports.ReadUser;
import module.core.usecase.ports.model.UserDto;
import module.delivery.rest.api.UserApi;
import module.delivery.rest.api.UserRequest;
import module.delivery.rest.api.UserResponse;

@Slf4j
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

    private final UserApiBuilder builder;
    private final CreateUser createUser;
    private final ReadUser readUser;

    @Override
    public UserResponse postUser(UserRequest request) {
        log.info("post user.");
        UserDto dto = builder.buildDto(request);
        dto = createUser.crateUser(dto);

        return builder.buildResponse(dto);
    }

    @Override
    public UserResponse putUser(UserRequest request, String id) {
        return null;
    }

    @Override
    public List<UserResponse> getUsers() {
        log.info("get users...");
        List<UserDto> dtos = readUser.searchUsers();
        return dtos.stream()
                .map(builder::buildResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUser(String id) {
        UserDto dto = readUser.searchUser(id);
        return builder.buildResponse(dto);
    }
}
