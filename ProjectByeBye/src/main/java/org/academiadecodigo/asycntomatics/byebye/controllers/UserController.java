package org.academiadecodigo.asycntomatics.byebye.controllers;

import org.academiadecodigo.asycntomatics.byebye.model.User;
import org.academiadecodigo.asycntomatics.byebye.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        return "registerForm";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "registerForm";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes)  {

        System.out.println(bindingResult.getModel());

        if (bindingResult.hasErrors()) {
            return "registerForm";
        }

        User savedUser = userService.save(user);

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + user.getFirstName() + " " + user.getLastName());
        return "services";
                //"redirect:/customer/" + user.getId();
    }

}