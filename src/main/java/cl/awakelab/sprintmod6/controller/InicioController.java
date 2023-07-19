package cl.awakelab.sprintmod6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    @GetMapping("/home")
    public String index(){
        return "home";
    }

    @GetMapping("/login")
    public String inicioSesion(){return "login";}

    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }

    @GetMapping("/bienvenida")
    public String bienvenida() { return "bienvenida"; }


}
