package repositories;

import models.User;

public interface UserDAO {
    User getByUsername(String username);
    void createUser(User user);
}
