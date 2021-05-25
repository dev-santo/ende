package com.ende.ende.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Controller {

    private static final String INDEX = "index";
    private static final String DASHBOARD = "dashboard";

    @RequestMapping()
    public ModelAndView index(){
        return new ModelAndView(INDEX);
    }

    @RequestMapping("/index")
    public ModelAndView indexooOutro(){
        return new ModelAndView(INDEX);
    }

    @RequestMapping("/dashboard")
    public ModelAndView dashboardIndex(){
        return new ModelAndView(DASHBOARD);
    }

}
