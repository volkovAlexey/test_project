package ua.domain;

import java.util.Objects;

public class Region {
    private Long id;
    private String name;
    private Country country;

    public Region() {
    }

    public Region(Long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        Region region = (Region) o;
        return Objects.equals(getId(), region.getId()) &&
                Objects.equals(getName(), region.getName()) &&
                Objects.equals(getCountry(), region.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry());
    }

    @Override
    public String toString() {
        return name;
    }
}
