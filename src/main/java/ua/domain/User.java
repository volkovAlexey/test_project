package ua.domain;

import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private String email;
    private Address address;
    private Long id;

    public User(String userName, String password, String email, Address address, Long id) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.id = id;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserName(), getPassword(), getEmail(), getAddress(), getId());
    }

    @Override
    public String toString() {
        return userName;
    }
}
