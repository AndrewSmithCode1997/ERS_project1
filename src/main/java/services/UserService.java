package services;

import io.javalin.http.NotFoundResponse;
import models.User;
import repositories.UserDAO;
import repositories.UserDAOImpl;

import java.util.Optional;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */

public class UserService {
    private UserDAO userDAO;

    public UserService(){
        this.userDAO = new UserDAOImpl();
    }

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     */
    public User validateCredentials(String username, String password) {
        User user = this.userDAO.getByUsername(username);
        //todo add exception catch for wrong username and/or wrong password
        if(user == null){
            return null;
        }
        if(!password.equals(user.getPassword()))
            return null;

        return user;
    }

    /**
     * See if the user object was created
     *
     * @param user
     * @return true if user was created/ returns false if the user was not created
     */
    public Boolean createUser(User user){
        //get user from db
        User userFromDb = userDAO.getByUsername(user.getUsername());

        if(userFromDb != null){
            return Boolean.FALSE;
        }

        this.userDAO.createUser(user);
        return Boolean.TRUE;
    }

    /**
     *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        User user = this.userDAO.getByUsername(username);
        if(user == null) {
            return Optional.empty();
        } else
            return Optional.of(user);
    }
}
