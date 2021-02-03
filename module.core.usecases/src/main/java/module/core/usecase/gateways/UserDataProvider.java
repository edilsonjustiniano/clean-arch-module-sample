package module.core.usecase.gateways;

import java.util.List;
import java.util.Optional;

import module.core.entity.User;

public interface UserDataProvider {

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(String id);

    List<User> findAllUsers();

    Optional<User> findUser(String id);
}
