package org.academiadecodigo.asycntomatics.byebye.controllers;

import org.academiadecodigo.asycntomatics.byebye.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/menu")
public class servicesController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = { "/services"})
    public String login() {
        return "services";
    }
}
