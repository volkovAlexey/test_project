package ua.domain;

import java.util.Objects;

public class User {
    private String name;
    private String password;
    private String email;
    private Address address;
    private Long id;

    public User(String name, String password, String email, Address address, Long id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getPassword(), getEmail(), getAddress(), getId());
    }
}
