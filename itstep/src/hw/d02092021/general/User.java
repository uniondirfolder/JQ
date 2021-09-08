package hw.d02092021.general;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

public class User implements Serializable {
    private String name;
    private String identifier;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public User(String name) {
        this.name = name;
        this.identifier = UUID.randomUUID() + OffsetDateTime.now(ZoneOffset.UTC).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return name.equals(user.name) && identifier.equals(user.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, identifier);
    }
}
