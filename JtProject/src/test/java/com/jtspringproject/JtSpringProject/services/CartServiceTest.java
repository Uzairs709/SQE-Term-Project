package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.cartDao;
import com.jtspringproject.JtSpringProject.models.Cart;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    @Mock
    private cartDao cartDao;

    @InjectMocks
    private cartService cartService;

    private Cart testCart;

    @Before
    public void setUp() {
        testCart = new Cart();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testAddCart() {
        when(cartDao.addCart(any())).thenReturn(testCart);

        Cart addedCart = cartService.addCart(new Cart());

        assertEquals(testCart, addedCart);
        verify(cartDao, times(1)).addCart(any());
    }

    @Test
    public void testGetCart() {
        when(cartDao.getCart(anyInt())).thenReturn(testCart);

        Cart retrievedCart = cartService.getCart(1);

        assertEquals(testCart, retrievedCart);
        verify(cartDao, times(1)).getCart(anyInt());
    }

    @Test
    public void testGetCarts() {
        List<Cart> cartList = new ArrayList<>();
        when(cartDao.getCarts()).thenReturn(cartList);

        List<Cart> retrievedCarts = cartService.getCarts();

        assertEquals(cartList, retrievedCarts);
        verify(cartDao, times(1)).getCarts();
    }

    @Test
    public void testUpdateCart() {
        // Assuming your updateCart method returns void
        cartService.updateCart(new Cart());

        verify(cartDao, times(1)).updateCart(any());
    }

    @Test
    public void testDeleteCart() {
        // Assuming your deleteCart method returns void
        cartService.deleteCart(new Cart());

        verify(cartDao, times(1)).deleteCart(any());
    }
}
