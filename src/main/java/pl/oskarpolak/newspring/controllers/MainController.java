package pl.oskarpolak.newspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.newspring.models.Person;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
public class MainController {


   // Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {

        ZonedDateTime now = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));

        System.out.println("Time now: " + now.toString());

        if(now.toLocalTime().getHour() >= 16){
            model.addAttribute("someString", "a");
        }else{
            model.addAttribute("someString", "b");
        }

        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String data(@RequestParam(value = "name") String name,
                       @RequestParam(value = "lastname") String lastname,
                       @RequestParam(value = "age") int age){
        return name + " " + lastname + " jest " + ((age >= 18) ? "pełnoletni" : "niepełnoletni");
    }

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newform(Model model) {
        model.addAttribute("personObject", new Person());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    @ResponseBody
    public String newformPost(Person person){
        return "Przyszła klasa: " + person.getName();
    }

    // Testujemy jak działa wzorzec builder ;)
    // Nie ma wpływu na działanie springa
    private void testBuilder() {
        Person person = new Person.Builder("Oskar")
                .age(27)
                .email("oskarpolak@cos.pl")
                .lastname("Polak")
                .number("788-232-123")
                .build();

        person.getAge();
    }






}
