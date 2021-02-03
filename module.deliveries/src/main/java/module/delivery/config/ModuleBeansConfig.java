package module.delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import module.core.usecase.core.UserBuilder;
import module.core.usecase.core.createuser.CreateUserService;
import module.core.usecase.core.readuser.ReadUserService;
import module.core.usecase.gateways.UserDataProvider;
import module.core.usecase.ports.CreateUser;
import module.core.usecase.ports.ReadUser;
import module.dataprovider.aurora.AuroraUserDataProviderImpl;
import module.dataprovider.aurora.AuroraUserRepository;
import module.dataprovider.memory.MemoryUserDataProviderImpl;
import module.delivery.rest.api.UserApi;
import module.delivery.rest.impl.UserApiBuilder;
import module.delivery.rest.impl.UserApiImpl;

@Configuration
public class ModuleBeansConfig {

    @Bean
    public UserDataProvider userDataProvider(AuroraUserRepository auroraUserRepository) {
        return new AuroraUserDataProviderImpl(auroraUserRepository);
    }

    // TO make it work in memory DB, comment the method above and uncomment the below
//    @Bean
//    public UserDataProvider userDataProvider() {
//        return new MemoryUserDataProviderImpl();
//    }

    @Bean
    public UserBuilder userBuilder() {
        return new UserBuilder();
    }

    @Bean
    public CreateUser createUser(UserBuilder userBuilder, UserDataProvider userDataProvider) {
        return new CreateUserService(userBuilder, userDataProvider);
    }

    @Bean
    public ReadUser readUser(UserBuilder userBuilder, UserDataProvider userDataProvider) {
        return new ReadUserService(userBuilder, userDataProvider);
    }

    @Bean
    public UserApiBuilder userApiBuilder() {
        return new UserApiBuilder();
    }

    @Bean
    public UserApi userApi(UserApiBuilder builder, CreateUser createUser, ReadUser readUser) {
        return new UserApiImpl(builder, createUser, readUser);
    }

}
