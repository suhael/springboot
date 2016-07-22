package com.suhael.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SimpleController {

    @RequestMapping(method = RequestMethod.GET)
    public String showSimpleResponse(){
        return "index";
    }
}
