package module.dataprovider;

import static java.time.Instant.now;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import module.core.entity.User;

@Table(name = "user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String email;

    @Builder.Default
    private long creationDate = now().toEpochMilli();
    @Builder.Default
    private long modificationDate = now().toEpochMilli();

    @Transient
    public static UserEntity toCreatedUserEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    @Transient
    public static UserEntity toUpdatedUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .creationDate(user.getCreationDate())
                .modificationDate(now().toEpochMilli())
                .build();
    }

    @Transient
    public User toUser() {
        return new User.Builder()
                .id(this.getId())
                .name(this.getName())
                .email(this.getEmail())
                .creationDate(this.getCreationDate())
                .modificationDate(this.getModificationDate())
                .build();
    }
}
