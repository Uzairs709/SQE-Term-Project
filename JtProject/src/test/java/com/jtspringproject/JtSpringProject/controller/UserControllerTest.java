package com.jtspringproject.JtSpringProject.controller;

import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.cartService;
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
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private userService userService;

    @Mock
    private productService productService;

    @Mock
    private cartService cartService;

    @InjectMocks
    private UserController userController;

    private List<User> userList;
    private List<Product> productList;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        userList = new ArrayList<>();
        userList.add(new User());

        productList = new ArrayList<>();
        productList.add(new Product());

        when(userService.checkUserExists("existingUsername")).thenReturn(true);
        when(userService.checkUserExists("newUsername")).thenReturn(false);
        when(userService.checkLogin("existingUsername", "password")).thenReturn(new User());
        when(userService.checkLogin("nonExistingUsername", "password")).thenReturn(null);
        when(userService.getUsers()).thenReturn(userList);
        when(productService.getProducts()).thenReturn(productList);
        when(cartService.getCarts()).thenReturn(new ArrayList<>());
    }

    @Test
    public void testUserLogin() throws Exception {
        mockMvc.perform(get("/userloginvalidate")
                        .param("username", "existingUsername")
                        .param("password", "password"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        mockMvc.perform(get("/userloginvalidate")
                        .param("username", "nonExistingUsername")
                        .param("password", "password"))
                .andExpect(status().isOk())
                .andExpect(view().name("userLogin"));
    }

    @Test
    public void testNewUserRegister() throws Exception {
        mockMvc.perform(get("/newuserregister")
                        .param("username", "existingUsername"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));

        mockMvc.perform(get("/newuserregister")
                        .param("username", "newUsername"))
                .andExpect(status().isOk())
                .andExpect(view().name("userLogin"));
    }

    @Test
    public void testGetProduct() throws Exception {
        mockMvc.perform(get("/user/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("uproduct"))
                .andExpect(model().attribute("products", hasSize(1)));
    }

    @Test
    public void testGetCartDetail() throws Exception {
        mockMvc.perform(get("/carts"))
                .andExpect(status().isOk());
    }
}
