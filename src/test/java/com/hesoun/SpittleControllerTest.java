package com.hesoun;

import com.hesoun.controller.SpittleController;
import com.hesoun.dao.SpittleDao;
import com.hesoun.entity.Spittle;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SpittleControllerTest {
    @Mock
    SpittleDao spittleDao;
    @InjectMocks
    SpittleController controller;

    @Test
    public void testLatestSpittles() throws Exception {
        //given
        List<Spittle> spittleList = createSpittleList(20);
        Mockito.when(spittleDao.findSpittles(Mockito.anyLong(), Mockito.anyInt())).thenReturn(spittleList);
        Long maxId = 500L;
        Integer spittleCount = 20;
        MockMvc mvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        //when
        mvc.perform(MockMvcRequestBuilders
                .get("/spittles?maxId=" + maxId + "&count=" + spittleCount))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("spittleList", CoreMatchers.hasItems(spittleList.toArray())));
        //then
        Mockito.verify(spittleDao).findSpittles(maxId, spittleCount);
    }

    @Test
    public void testSpittle() throws Exception {
        //given
        Spittle testSpittle = new Spittle("Test Spittle");
        Long testSpittleId = 10L;
        MockMvc mock = MockMvcBuilders.standaloneSetup(controller).build();
        //when
        Mockito.when(spittleDao.findOne(testSpittleId)).thenReturn(testSpittle);

        //then
        mock.perform(MockMvcRequestBuilders.get("/spittles/" + testSpittleId))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle",testSpittle));

        Mockito.verify(spittleDao).findOne(Mockito.eq(testSpittleId));
    }

    private List<Spittle> createSpittleList(int num) {
        List<Spittle> result = new ArrayList<Spittle>(num);
        for (int i = 0; i < num; i++) {
            result.add(new Spittle("Spittle " + i, LocalDateTime.now()));
        }
        return result;
    }
}
