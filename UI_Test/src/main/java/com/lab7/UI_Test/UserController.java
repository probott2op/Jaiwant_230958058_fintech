package com.lab7.UI_Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam(defaultValue = "1") int page, Model model)
    {
        int pageSize = 2;
        Page<User> userPage = userService.getPaginatedUsers(page -1 , pageSize);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("pageTitle", "User List");
        return "users";
    }

    @GetMapping("/listUsers")
    public String listUsers(@RequestParam(defaultValue = "1") int page, Model model)
    {
        Page<User> userPage = userService.findPaginated(page, 10);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        return "userlist";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model)
    {
        model.addAttribute("pageTitle", "Add user");
        model.addAttribute("user", new User());
        return "userform";
    }

    @PostMapping("/save")
    public String SaveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("pageTitle", "Add user");
            return "userform";
        }

        userService.saveUser(user);
        return "redirect:/v1/users";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, Model model)
    {
        userService.deleteById(id);
        model.addAttribute("message", "User deleted succesfully");
        return "redirect:/v1/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model)
    {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "userupdate";
    }

    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable Long id, @Valid @ModelAttribute("user") User user, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("pageTitle", "Update User");
            return "userupdate";
        }
        userService.updateUser(id, user);
        return "redirect:/v1/users";
    }
}
