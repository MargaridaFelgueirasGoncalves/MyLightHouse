package org.academiadecodigo.asycntomatics.byebye.controllers;

import org.academiadecodigo.asycntomatics.byebye.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/")
public class FrontPageController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = { "/", ""})
    public String frontPage() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String loginPage() {
        return "log_in";
    }

    @RequestMapping(method = RequestMethod.GET, path = { "/", ""})
    public String frontPage() {
        return "log_in";
    }



}
