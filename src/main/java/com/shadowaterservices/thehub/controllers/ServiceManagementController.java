package com.shadowaterservices.thehub.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shadowaterservices.thehub.data.repositories.PostRepository;

@RestController
@RequestMapping("/services")
public class ServiceManagementController {
	@Autowired
	PostRepository postRepository;
	
    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public ServiceManagementController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }	

    @RequestMapping("/twitter")
    public ModelAndView helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return new ModelAndView("redirect:/connect/twitter");
        }

        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline();
       
        ModelAndView mav = new ModelAndView("tweets");
        mav.addObject("tweets", tweets);

        return mav;
    }
}
