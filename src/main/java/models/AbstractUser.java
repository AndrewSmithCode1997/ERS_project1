package models;


import java.util.Objects;

public class AbstractUser {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String userEmail;
    private int roleId;

    public AbstractUser() {}

    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //constructor for getting username and user role
    public AbstractUser(String username, String password, String firstname, String lastname, String userEmail) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEmail = userEmail;
    }

    //constructor for creating a user
    public AbstractUser(String username, String password, String firstname, String lastname, String userEmail, int roleId) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public AbstractUser(int id, String username, String password, String firstname, String lastname, String userEmail, int roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractUser)) return false;
        AbstractUser that = (AbstractUser) o;
        return id == that.id && username.equals(that.username) && password.equals(that.password) && roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roleId);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
