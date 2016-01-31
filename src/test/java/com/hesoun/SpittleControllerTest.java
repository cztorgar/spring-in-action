package com.hesoun;

import com.hesoun.controller.SpittleController;
import com.hesoun.dao.SpittleDao;
import com.hesoun.entity.Spittle;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SpittleControllerTest {

    @Test
    public void testSpittleControler() throws Exception {
        List<Spittle> spittleList = createSpittleList(20);

        SpittleDao dao = Mockito.mock(SpittleDao.class);
        Mockito.when(dao.findSpittles(Mockito.anyLong(),Mockito.anyInt())).thenReturn(spittleList);

        Long spittleId = 500L;
        Integer maxSpittles = 20;

        SpittleController controller = new SpittleController(dao);
        MockMvc mvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mvc.perform(MockMvcRequestBuilders
                .get("/spittles?count=" + spittleId + "&max=" + maxSpittles))
                .andExpect(MockMvcResultMatchers.model()
                        .attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("spittleList", CoreMatchers.hasItems(spittleList.toArray())));
        Mockito.verify(dao).findSpittles(spittleId,maxSpittles);
    }

    private List<Spittle> createSpittleList(int num) {
        List<Spittle> result = new ArrayList<Spittle>(num);
        for (int i = 0; i < num; i++) {
            result.add(new Spittle("Spittle " + i, LocalDateTime.now()));
        }
        return result;
    }
}
