package module.dataprovider.aurora;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import module.core.entity.User;
import module.core.usecase.gateways.UserDataProvider;
import module.dataprovider.UserEntity;

@RequiredArgsConstructor
public class AuroraUserDataProviderImpl implements UserDataProvider {

    private final AuroraUserRepository repository;

    @Override
    public User createUser(User user) {
        UserEntity userEntity = repository.save(UserEntity.toCreatedUserEntity(user));

        return userEntity.toUser();
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = repository.save(UserEntity.toUpdatedUserEntity(user));

        return userEntity.toUser();
    }

    @Override
    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll().stream()
                .map(UserEntity::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUser(String id) {
        return repository.findById(id).map(UserEntity::toUser);
    }
}
