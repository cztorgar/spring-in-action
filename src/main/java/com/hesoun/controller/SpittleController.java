package com.hesoun.controller;

import com.hesoun.dao.SpittleDao;
import com.hesoun.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleDao spittleDao;

    @Autowired
    public SpittleController(SpittleDao spittleDao) {
        this.spittleDao = spittleDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String latestSpittles(Map<String,List<Spittle>> model) {
        model.put("spittleList", spittleDao.findSpittles(Integer.MAX_VALUE, 20));
        return "spittles";
    }


}
