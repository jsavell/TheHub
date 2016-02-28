package com.shadowaterservices.thehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shadowaterservices.thehub.data.repositories.UserRepository;

@RestController
public class AppController {
	@Autowired
	UserRepository userRepository;

	/*
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    */
    
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("users", userRepository.findAll());
        return mav;
    }

}