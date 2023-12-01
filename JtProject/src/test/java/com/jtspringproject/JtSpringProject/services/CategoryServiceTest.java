package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.categoryDao;
import com.jtspringproject.JtSpringProject.models.Category;
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
public class CategoryServiceTest {

    @Mock
    private categoryDao categoryDao;

    @InjectMocks
    private categoryService categoryService;

    private Category testCategory;

    @Before
    public void setUp() {
        testCategory = new Category();
    }

    @After
    public void tearDown() {
        // Clean up any data after each test
    }

    @Test
    public void testAddCategory() {
        when(categoryDao.addCategory(anyString())).thenReturn(testCategory);

        Category addedCategory = categoryService.addCategory("TestCategory");

        assertEquals(testCategory, addedCategory);
        verify(categoryDao, times(1)).addCategory(anyString());
    }

    @Test
    public void testGetCategories() {
        List<Category> categoryList = new ArrayList<>();
        when(categoryDao.getCategories()).thenReturn(categoryList);

        List<Category> retrievedCategories = categoryService.getCategories();

        assertEquals(categoryList, retrievedCategories);
        verify(categoryDao, times(1)).getCategories();
    }

    @Test
    public void testDeleteCategory() {
        when(categoryDao.deletCategory(anyInt())).thenReturn(true);

        Boolean isDeleted = categoryService.deleteCategory(1);

        assertEquals(true, isDeleted);
        verify(categoryDao, times(1)).deletCategory(anyInt());
    }

    @Test
    public void testUpdateCategory() {
        when(categoryDao.updateCategory(anyInt(), anyString())).thenReturn(testCategory);

        Category updatedCategory = categoryService.updateCategory(1, "UpdatedCategory");

        assertEquals(testCategory, updatedCategory);
        verify(categoryDao, times(1)).updateCategory(anyInt(), anyString());
    }

    @Test
    public void testGetCategory() {
        when(categoryDao.getCategory(anyInt())).thenReturn(testCategory);

        Category retrievedCategory = categoryService.getCategory(1);

        assertEquals(testCategory, retrievedCategory);
        verify(categoryDao, times(1)).getCategory(anyInt());
    }
}
