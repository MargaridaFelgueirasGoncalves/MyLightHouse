package org.academiadecodigo.asycntomatics.byebye.controllers;

import org.academiadecodigo.asycntomatics.byebye.model.User;
import org.academiadecodigo.asycntomatics.byebye.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = { "/login"})
    public String login() {
        return "log_in";
    }

    @RequestMapping(method = RequestMethod.GET, path = { "/register"})
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@RequestBody Model model, RedirectAttributes redirectAttributes)  {

        User user = new User();

        BeanUtils.copyProperties(model, user);

        System.out.println(user);

        User savedUser = userService.save(user);

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + user.getFirstName() + " " + user.getLastName());
        return "services";
                //"redirect:/customer/" + user.getId();
    }

}