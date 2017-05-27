package pl.oskarpolak.newspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.oskarpolak.newspring.models.SimpleBean;

@Controller
public class MainController {

    @Autowired
    SimpleBean simpleBean;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("someString", "Pochodzę z controllera!");
        return "index";
    }



}
