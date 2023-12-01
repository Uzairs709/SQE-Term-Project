package com.jtspringproject.JtSpringProject.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testGetId() {
        category.setId(1);
        assertEquals(1, category.getId());
    }

    @Test
    public void testSetId() {
        category.setId(1);
        assertEquals(1, category.getId());
    }

    @Test
    public void testGetName() {
        category.setName("TestCategory");
        assertEquals("TestCategory", category.getName());
    }

    @Test
    public void testSetName() {
        category.setName("TestCategory");
        assertEquals("TestCategory", category.getName());
    }

    // Add more tests based on your requirements
}
