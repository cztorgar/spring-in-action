package com.hesoun;

import com.hesoun.controller.HomeController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Jakub Hesoun
 */
public class HomeControllerTest {

    @Test
    public void homeControllerTest() throws Exception {
        HomeController crtl = new HomeController();
        MockMvc mock = MockMvcBuilders.standaloneSetup(crtl).build();
        mock.perform(MockMvcRequestBuilders.get("/web"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
        Assert.assertEquals(crtl.homePage(), "home");
    }
}
