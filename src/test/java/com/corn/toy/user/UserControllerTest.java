package com.corn.toy.user;

import com.corn.toy.user.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class) // MockMvc가 만들어져서 사용할 수 있음
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", iterableWithSize(3)))
                .andExpect(jsonPath("$[0]['name']", is(equalTo("어린깡냉"))));
    }

    @Test
    public void findByName() throws Exception {
        mockMvc.perform(get("/users/KANG"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", iterableWithSize(1)))
                .andExpect(jsonPath("$[0]['name']", is(equalTo("KANG"))));
    }
}
