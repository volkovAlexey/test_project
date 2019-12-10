package ua.domain;

import java.util.List;
import java.util.Objects;

public class Country {
    private Long id;
    private String name;
    private List<Region> regions;

    public Country() {
    }

    public Country(Long id, String name, List<Region> regions) {
        this.id = id;
        this.name = name;
        this.regions = regions;
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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(getId(), country.getId()) &&
                Objects.equals(getName(), country.getName()) &&
                Objects.equals(getRegions(), country.getRegions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRegions());
    }
}
