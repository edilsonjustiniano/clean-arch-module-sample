package module.dataprovider.memory;

import static java.time.Instant.now;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import module.core.entity.User;
import module.core.usecase.gateways.UserDataProvider;

public class MemoryUserDataProviderImpl implements UserDataProvider {

    private final Map<String, User> database = new HashMap<>();

    @Override
    public User createUser(User user) {
        user.setCreationDate(now().toEpochMilli());
        user.setModificationDate(now().toEpochMilli());
        user.setId(UUID.randomUUID().toString());
        database.put(user.getId(), user);

        return user;
    }

    @Override
    public User updateUser(User user) {
        user.setModificationDate(now().toEpochMilli());
        database.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        database.keySet().removeIf(x -> x.equals(id));
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<User> findUser(String id) {
        return database.entrySet().stream()
                .filter(register -> id.equals(register.getKey()))
                .map(Map.Entry::getValue)
                .findAny();
    }
}
