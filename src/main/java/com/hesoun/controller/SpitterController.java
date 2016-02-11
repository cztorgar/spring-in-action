package com.hesoun.controller;

import com.hesoun.dao.SpitterDao;
import com.hesoun.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Works with Spitters.
 *
 * @author Jakub Hesoun
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterDao spitterDao;

    @Autowired
    public SpitterController(SpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "registerForm";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String saveSpitter(@Valid Spitter spitter, BindingResult errors) {
        if (errors.hasErrors()) {
            return "registerForm";

        }
        spitterDao.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitter(@PathVariable String username, Model model) {
        model.addAttribute(spitterDao.findByUsername(username));
        return "profile";
    }
}
