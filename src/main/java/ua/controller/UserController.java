package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.controller.forms.Form;
import ua.domain.Address;
import ua.domain.Country;
import ua.domain.Region;
import ua.domain.User;
import ua.service.AddressService;
import ua.service.CountryService;
import ua.service.RegionService;
import ua.service.UserService;
import ua.validator.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private Validator validator;

    private Map<String, String> errorMap = new HashMap<>();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/authorization")
    public String authorization(@ModelAttribute Form form, Model model) {
        loginValidation(form);
        if (!errorMap.isEmpty()) {
            model.addAttribute("error", errorMap);
            return login();
        }
        User user = userService.getUserByName(form.getUserName());
        model.addAttribute("result", "Welcome " + user);
        model.addAttribute("user", user);
        return "userPage";
    }

    @GetMapping(value = {"/login", "/authorization"})
    public String login() {
        return "login";
    }

    @GetMapping(value = "/welcome")
    public String hello(Model model) {
        model.addAttribute("result", "Welcome");
        return "welcome";
    }

    @GetMapping(value = "/registration_form")
    public String registration(Model model) {
        List<Country> countryList = countryService.getAll();
        model.addAttribute("list", countryList);
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute Form form, Model model) {
        validation(form);
        if (!errorMap.isEmpty()) {
            model.addAttribute("error", errorMap);
            return registration(model);
        }
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());

        Address address = new Address();
        address.setCity(form.getCityName());
        Address userAddress = addressService.addOne(address, form.getRegionId());

        userService.addUser(user, userAddress.getId());

        model.addAttribute("user", user);
        model.addAttribute("result", "Welcome " + user);
        return "userPage";
    }

    @GetMapping(value = "/update_form")
    public String updateForm(@ModelAttribute Form form, Model model) {
        List<Country> countryList = countryService.getAll();
        model.addAttribute("list", countryList);

        User user = userService.getOne(form.getUserId());
        model.addAttribute("user", user);
        return "updateFormPage";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Form form, Model model) {
        User user = new User();
        user.setId(form.getUserId());
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());

        Address address = new Address();
        address.setCity(form.getCityName());
        Address userAddress = addressService.addOne(address, form.getRegionId());

        User userUpdate = userService.update(userAddress.getId(), user);

        model.addAttribute("user", userUpdate);
        model.addAttribute("result", userUpdate + " your data updated successfully");
        return "userPage";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute Form form, Model model) {
        userService.delete(form.getUserId());
        model.addAttribute("result", "Welcome");
        return "welcome";
    }

    @GetMapping(value = "/regions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Region> getRegions(@RequestParam(value = "country_id") String id, Model model) {
        Long countryId = Long.parseLong(id);
        List<Region> regions = regionService.findAllByID(countryId);
        model.addAttribute("regions", regions);
        return regions;
    }

    private void validation(Form form) {
        errorMap.clear();
        validator.validateStringField("userName", form.getUserName(), errorMap);
        if (errorMap.isEmpty()) {
            validator.nameValidation("userName", form.getUserName(), errorMap);
        }
        validator.emailValidation("email", form.getEmail(), errorMap);
    }

    private void loginValidation(Form form) {
        errorMap.clear();
        validator.checkUser("userName", form.getUserName(), form.getPassword(), errorMap);
    }
}
