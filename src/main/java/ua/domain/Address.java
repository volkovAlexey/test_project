package ua.domain;

import java.util.Objects;

public class Address {
    private Long id;
    private Region region;
    private String city;

    public Address() {
    }

    public Address(Long id, Region region, String city) {
        this.id = id;
        this.region = region;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId()) &&
                Objects.equals(getRegion(), address.getRegion()) &&
                Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegion(), getCity());
    }
}
