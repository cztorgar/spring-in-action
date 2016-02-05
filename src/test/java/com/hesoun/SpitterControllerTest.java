package com.hesoun;

import com.hesoun.controller.SpitterController;
import com.hesoun.dao.SpitterDao;
import com.hesoun.entity.Spitter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class SpitterControllerTest {

    @Mock
    private SpitterDao spitterDao;
    @InjectMocks
    private SpitterController controller;

    @Test
    public void testRegister() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void testSaveSpitter() throws Exception{
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        //when
        ArgumentCaptor<Spitter> captor = ArgumentCaptor.forClass(Spitter.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));

        //then
        Mockito.verify(spitterDao).save(captor.capture());
        Assert.assertEquals(captor.getValue().getFirstName(), "Jack");
        Assert.assertEquals(captor.getValue().getLastName(), "Bauer");
        Assert.assertEquals(captor.getValue().getUsername(), "jbauer");
        Assert.assertEquals(captor.getValue().getPassword(),"24hours");
    }
}
