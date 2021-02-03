package module.core.usecase.core;

import module.core.entity.User;
import module.core.usecase.ports.model.UserDto;

public class UserBuilder {

    public User buildUser(UserDto dto) {
        return new User.Builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public UserDto buildDto(User user) {
        return  UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
