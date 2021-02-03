package module.delivery.rest.impl;

import module.core.usecase.ports.model.UserDto;
import module.delivery.rest.api.UserRequest;
import module.delivery.rest.api.UserResponse;

public class UserApiBuilder {

    public UserDto buildDto(UserRequest request) {
        return UserDto.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }

    public UserResponse buildResponse(UserDto dto) {
        return UserResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }
}
