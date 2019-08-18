package com.corn.toy.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void init() throws Exception {
        // 요청 "/"
        // 응답
        // - 모델 name : cron
        // - 뷰 이름 : hello
        mockMvc.perform(get("/init"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("init"))
                .andExpect(model().attribute("name", is("corn")))
                .andExpect(content().string(containsString("corn")));
    }
}