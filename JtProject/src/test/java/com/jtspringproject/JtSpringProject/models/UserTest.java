package com.jtspringproject.JtSpringProject.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testGetId() {
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void testSetId() {
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void testGetUsername() {
        user.setUsername("TestUser");
        assertEquals("TestUser", user.getUsername());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("TestUser");
        assertEquals("TestUser", user.getUsername());
    }

    @Test
    public void testGetEmail() {
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testGetPassword() {
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testGetRole() {
        user.setRole("ROLE_USER");
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void testSetRole() {
        user.setRole("ROLE_USER");
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void testGetAddress() {
        user.setAddress("Test Address");
        assertEquals("Test Address", user.getAddress());
    }

    @Test
    public void testSetAddress() {
        user.setAddress("Test Address");
        assertEquals("Test Address", user.getAddress());
    }

    // Add more tests based on your requirements
}
