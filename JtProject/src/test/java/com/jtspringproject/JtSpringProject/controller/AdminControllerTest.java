package com.jtspringproject.JtSpringProject.controller;

import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.categoryService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private userService userService;

    @Mock
    private categoryService categoryService;

    @Mock
    private productService productService;

    @InjectMocks
    private AdminController adminController;

    private List<User> userList;
    private List<Category> categoryList;
    private List<Product> productList;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();

        userList = new ArrayList<>();
        userList.add(new User());

        categoryList = new ArrayList<>();
        categoryList.add(new Category());

        productList = new ArrayList<>();
        productList.add(new Product());

        when(userService.getUsers()).thenReturn(userList);
        when(categoryService.getCategories()).thenReturn(categoryList);
        when(productService.getProducts()).thenReturn(productList);
    }

    @Test
    public void testGetCustomerDetail() throws Exception {
        mockMvc.perform(get("/admin/customers"))
                .andExpect(status().isOk())
                .andExpect(view().name("displayCustomers"))
                .andExpect(model().attribute("customers", hasSize(1)));
    }

    @Test
    public void testGetcategory() throws Exception {
        mockMvc.perform(get("/admin/categories"))
                .andExpect(status().isOk())
                .andExpect(view().name("categories"))
                .andExpect(model().attribute("categories", hasSize(1)));
    }

    @Test
    public void testGetproduct() throws Exception {
        mockMvc.perform(get("/admin/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products", hasSize(1)));
    }

    // Add more tests for other methods as needed
}
