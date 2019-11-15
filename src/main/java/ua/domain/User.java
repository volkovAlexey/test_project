package ua.domain;

public class User {
    private String name;
    private String password;
    private Country countryName;
    private Long id;

    public User(String name, String password, Country countryName, Long id) {
        this.name = name;
        this.password = password;
        this.countryName = countryName;
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

    public Country getCounrtyName() {
        return countryName;
    }

    public void setCounrtyName(Country countryName) {
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
