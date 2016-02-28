package com.shadowaterservices.thehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shadowaterservices.thehub.data.repositories.PostRepository;
import com.shadowaterservices.thehub.data.repositories.UserRepository;

@RestController
public class AppController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", userRepository.findAll());
        return mav;
    }

    @RequestMapping("/posts")
    public ModelAndView getPosts() {
        ModelAndView mav = new ModelAndView("posts");
        mav.addObject("posts", postRepository.findAll());
        return mav;
    }
}