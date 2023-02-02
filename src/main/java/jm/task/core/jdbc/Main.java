package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        try {
            userService.createUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            userService.saveUser("Adam", "God", (byte) 100);
            userService.saveUser("Eva", "God", (byte) 100);
            userService.saveUser("Cat", "NaN", (byte) 2);
            userService.saveUser("Dog", "NaN", (byte) 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            userService.getAllUsers().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            userService.cleanUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            userService.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
