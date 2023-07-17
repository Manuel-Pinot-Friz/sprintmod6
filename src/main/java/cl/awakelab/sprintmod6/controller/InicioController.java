package cl.awakelab.sprintmod6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicioSesion")
public class InicioController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/inicioSesion")
    public String inicioSesion(){return "login";}

    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }
}