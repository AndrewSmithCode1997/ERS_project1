package models;

import java.util.Arrays;
import java.util.Optional;

//todo figure out a way to use enums in user creation and retrieval
public enum Role {
    EMPLOYEE(1, "Employee"),
    MANAGER(2, "Manager");

    private final int id;
    private final String role;

    Role(int id, String role) {

        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public static Optional<Role> getRoleId(int val) {
        return Arrays.stream(Role.values())
                .filter(roles -> roles.id == val)
                .findFirst();
    }

}
