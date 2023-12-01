package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.productDao;
import com.jtspringproject.JtSpringProject.models.Product;
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
public class ProductServiceTest {

    @Mock
    private productDao productDao;

    @InjectMocks
    private productService productService;

    private Product testProduct;

    @Before
    public void setUp() {
        testProduct = new Product();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testGetProducts() {
        List<Product> productList = new ArrayList<>();
        when(productDao.getProducts()).thenReturn(productList);

        List<Product> retrievedProducts = productService.getProducts();

        assertEquals(productList, retrievedProducts);
        verify(productDao, times(1)).getProducts();
    }

    @Test
    public void testAddProduct() {
        when(productDao.addProduct(any())).thenReturn(testProduct);

        Product addedProduct = productService.addProduct(new Product());

        assertEquals(testProduct, addedProduct);
        verify(productDao, times(1)).addProduct(any());
    }

    @Test
    public void testGetProduct() {
        when(productDao.getProduct(anyInt())).thenReturn(testProduct);

        Product retrievedProduct = productService.getProduct(1);

        assertEquals(testProduct, retrievedProduct);
        verify(productDao, times(1)).getProduct(anyInt());
    }

    @Test
    public void testUpdateProduct() {
        when(productDao.updateProduct(any())).thenReturn(testProduct);

        Product updatedProduct = productService.updateProduct(1, new Product());

        assertEquals(testProduct, updatedProduct);
        verify(productDao, times(1)).updateProduct(any());
    }

    @Test
    public void testDeleteProduct() {
        when(productDao.deletProduct(anyInt())).thenReturn(true);

        boolean isDeleted = productService.deleteProduct(1);

        assertEquals(true, isDeleted);
        verify(productDao, times(1)).deletProduct(anyInt());
    }
}
