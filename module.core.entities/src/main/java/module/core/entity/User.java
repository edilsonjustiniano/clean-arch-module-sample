package module.core.entity;

public class User {

    private String id;
    private String name;
    private String email;
    private long creationDate;
    private long modificationDate;

    public User() {
    }

    public User(String id, String name, String email, long creationDate, long modificationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(long modificationDate) {
        this.modificationDate = modificationDate;
    }

    public static final class Builder {

        private User user = new User();

        public Builder id(String id) {
            user.setId(id);
            return this;
        }

        public Builder name(String name) {
            user.setName(name);
            return this;
        }

        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder creationDate(long creationDate) {
            user.setCreationDate(creationDate);
            return this;
        }

        public Builder modificationDate(long modificationDate) {
            user.setModificationDate(modificationDate);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
