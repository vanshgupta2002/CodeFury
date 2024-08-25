package service;


import static org.junit.jupiter.api.Assertions.*;

import com.mycomapny.business.Admin;
import com.mycomapny.exceptions.UserNotFoundException;
import com.mycomapny.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testAddAndRetrieveUser() {
        Admin admin = new Admin("Admin", "admin@example.com", "1234567890");
        userService.addUser(admin);
        assertDoesNotThrow(() -> {
            assertEquals(admin, userService.getUserByEmail("admin@example.com"));
        });
    }

    @Test
    public void testGetUserThrowsExceptionWhenNotFound() {
        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserByEmail("nonexistent@example.com");
        });
    }
}
