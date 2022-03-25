package models;

public class User extends AbstractUser{

    public User() {}

    public User(String username, String password){
        super(username, password);
    }

    public User(String username, String password, String firstname, String lastname, String userEmail){
        super(username, password, firstname, lastname, userEmail);
    }

    public User(String username, String password, String firstname, String lastname, String userEmail, int roleId) {
        super(username, password, firstname, lastname, userEmail, roleId);
    }

    public User(int id, String username, String password, String firstname, String lastname, String userEmail, int roleId) {
        super(id, username, password, firstname, lastname, userEmail, roleId);
    }
} //end of class User
