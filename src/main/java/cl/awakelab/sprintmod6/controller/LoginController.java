package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/inicioSesion")
    public class LoginController {

        @Autowired
        IUsuarioService objIUsuarioService;

        @PostMapping("/{run}{clave}")
        public String inicioSesion(@PathVariable int run,@PathVariable String clave ){
//        objIUsuarioSe
            return "bienvenida";
        }
    }

