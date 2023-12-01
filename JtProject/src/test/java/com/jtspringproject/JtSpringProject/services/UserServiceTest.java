package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.userDao;
import com.jtspringproject.JtSpringProject.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private userDao userDao;

    @InjectMocks
    private userService userService;

    private User testUser;

    @Before
    public void setUp() {
        testUser = new User();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testGetUsers() {
        List<User> userList = new ArrayList<>();
        when(userDao.getAllUser()).thenReturn(userList);

        List<User> retrievedUsers = userService.getUsers();

        assertEquals(userList, retrievedUsers);
        verify(userDao, times(1)).getAllUser();
    }

    @Test
    public void testAddUser() {
        when(userDao.saveUser(any())).thenReturn(testUser);

        User addedUser = userService.addUser(new User());

        assertEquals(testUser, addedUser);
        verify(userDao, times(1)).saveUser(any());
    }

    @Test
    public void testCheckUserExists() {
        when(userDao.userExists(anyString())).thenReturn(true);

        boolean userExists = userService.checkUserExists("TestUser");

        assertTrue(userExists);
        verify(userDao, times(1)).userExists(anyString());
    }

    @Test
    public void testCheckUserNotExists() {
        when(userDao.userExists(anyString())).thenReturn(false);

        boolean userExists = userService.checkUserExists("NonExistingUser");

        assertFalse(userExists);
        verify(userDao, times(1)).userExists(anyString());
    }

    @Test
    public void testCheckLogin() {
        when(userDao.getUser(anyString(), anyString())).thenReturn(testUser);

        User loggedInUser = userService.checkLogin("TestUser", "password");

        assertEquals(testUser, loggedInUser);
        verify(userDao, times(1)).getUser(anyString(), anyString());
    }
}
