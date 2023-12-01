package com.jtspringproject.JtSpringProject.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testGetId() {
        product.setId(1);
        assertEquals(1, product.getId());
    }

    @Test
    public void testSetId() {
        product.setId(1);
        assertEquals(1, product.getId());
    }

    @Test
    public void testGetName() {
        product.setName("TestProduct");
        assertEquals("TestProduct", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("TestProduct");
        assertEquals("TestProduct", product.getName());
    }

    @Test
    public void testGetImage() {
        product.setImage("test_image.jpg");
        assertEquals("test_image.jpg", product.getImage());
    }

    @Test
    public void testSetImage() {
        product.setImage("test_image.jpg");
        assertEquals("test_image.jpg", product.getImage());
    }

    @Test
    public void testGetCategory() {
        Category category = new Category();
        product.setCategory(category);
        assertNotNull(product.getCategory());
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testSetCategory() {
        Category category = new Category();
        product.setCategory(category);
        assertNotNull(product.getCategory());
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testGetQuantity() {
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testGetPrice() {
        product.setPrice(50);
        assertEquals(50, product.getPrice());
    }

    @Test
    public void testSetPrice() {
        product.setPrice(50);
        assertEquals(50, product.getPrice());
    }

    @Test
    public void testGetWeight() {
        product.setWeight(2);
        assertEquals(2, product.getWeight());
    }

    @Test
    public void testSetWeight() {
        product.setWeight(2);
        assertEquals(2, product.getWeight());
    }

    @Test
    public void testGetDescription() {
        product.setDescription("Test description");
        assertEquals("Test description", product.getDescription());
    }

    @Test
    public void testSetDescription() {
        product.setDescription("Test description");
        assertEquals("Test description", product.getDescription());
    }

    // Add more tests based on your requirements
}
