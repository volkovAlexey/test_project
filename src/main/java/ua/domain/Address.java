package ua.domain;

import java.util.Objects;

public class Address {
    private String country;
    private String region;
    private String city;

    public Address() {
    }

    public Address(String country, String region, String city) {
        this.country = country;
        this.region = region;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
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
        return Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getRegion(), address.getRegion()) &&
                Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCountry(), getRegion(), getCity());
    }
}
