package org.academiadecodigo.asycntomatics.byebye.controllers;

import org.academiadecodigo.asycntomatics.byebye.model.User;
import org.academiadecodigo.asycntomatics.byebye.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
        return "register/" + id;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String saveCustomer(@ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/";
        }

        User savedUser = userService.save(user);

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + user.getFirstName() + " " + user.getLastName());

        return "redirect:user/posregister";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/api/newuser")
    public String saveCustomerApi(@RequestBody User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "/";
        }

        User savedUser = userService.save(user);

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + user.getFirstName() + " " + user.getLastName());

        return "redirect:user/posregister";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/posregister")
    public String posRegister(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "register/after_registration";
    }

}