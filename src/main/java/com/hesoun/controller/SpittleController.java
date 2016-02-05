package com.hesoun.controller;

import com.hesoun.dao.SpittleDao;
import com.hesoun.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Jakub Hesoun
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_INTEGER_ID = Integer.MAX_VALUE + "";
    private SpittleDao spittleDao;

    @Autowired
    public SpittleController(SpittleDao spittleDao) {
        this.spittleDao = spittleDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String latestSpittles(@RequestParam(defaultValue = MAX_INTEGER_ID) Long maxId, @RequestParam(defaultValue = "20") Integer count, Map<String, List<Spittle>> model) {
        model.put("spittleList", spittleDao.findSpittles(maxId, count));
        return "spittles";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable("id") String spittleId, Model model) {
        model.addAttribute(spittleDao.findOne(Long.parseLong(spittleId)));
        return "spittle";
    }
}
