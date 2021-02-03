package module.dataprovider.aurora;

import org.springframework.data.jpa.repository.JpaRepository;

import module.dataprovider.UserEntity;

public interface AuroraUserRepository extends JpaRepository<UserEntity, String> {

}
