package hw6.domain;

import java.util.Objects;

public class SiteUser {

    private final String number;
    private final String user;
    private final String description;

    public SiteUser(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteUser siteUser = (SiteUser) o;
        return Objects.equals(number, siteUser.number) &&
                Objects.equals(user, siteUser.user) &&
                Objects.equals(description, siteUser.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }
}
