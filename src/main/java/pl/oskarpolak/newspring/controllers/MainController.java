package pl.oskarpolak.newspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.oskarpolak.newspring.models.SimpleBean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
public class MainController {

    @Autowired
    SimpleBean simpleBean;

   // Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {

        ZonedDateTime now = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));

        System.out.println("Time now: " + now.toString());

        if(now.toLocalTime().getHour() >= 16){
            model.addAttribute("someString", "Czas iść na piwko!");
        }else{
            model.addAttribute("someString", "Muszę posiedzieć jeszcze z tym Oskarem...");
        }

        return "index";
    }



}
