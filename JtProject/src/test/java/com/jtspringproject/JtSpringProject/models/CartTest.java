package com.jtspringproject.JtSpringProject.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest {

    private Cart cart;

    @Before
    public void setUp() {
        cart = new Cart();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testGetId() {
        cart.setId(1);
        assertEquals(1, cart.getId());
    }

    @Test
    public void testGetCustomer() {
        User user = new User();
        cart.setCustomer(user);
        assertNotNull(cart.getCustomer());
        assertEquals(user, cart.getCustomer());
    }

    @Test
    public void testSetCustomer() {
        User user = new User();
        cart.setCustomer(user);
        assertNotNull(cart.getCustomer());
        assertEquals(user, cart.getCustomer());
    }

    @Test
    public void testGetProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        products.add(product1);
        products.add(product2);

        cart.setProducts(products);

        assertNotNull(cart.getProducts());
        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testSetProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        products.add(product1);
        products.add(product2);

        cart.setProducts(products);

        assertNotNull(cart.getProducts());
        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        cart.addProduct(product);

        assertNotNull(cart.getProducts());
        assertEquals(1, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product();
        cart.addProduct(product);

        assertNotNull(cart.getProducts());
        assertEquals(1, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product));

        cart.removeProduct(product);

        assertEquals(0, cart.getProducts().size());
    }
}
