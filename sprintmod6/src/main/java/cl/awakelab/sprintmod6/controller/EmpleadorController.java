package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Empleador;
import cl.awakelab.sprintmod6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
    @Autowired
    IEmpleadorService objIEmpleadorService;

    @GetMapping
    public String listarEmpleadores(Model model){
        List<Empleador> listaEmpleadores = objIEmpleadorService.listarEmpleador();
        model.addAttribute("empleadores",listaEmpleadores);
        return "listarEmpleadores";
    }

    @PostMapping("/crearEmpleador")
    public Empleador crearEmpleador(@RequestBody Empleador empleador){return objIEmpleadorService.crearEmpleador(empleador);}

    @GetMapping("/{idEmpleador}")
    public String buscarEmpleadorPorId(@PathVariable int idEmpleador, Model model){
        Empleador empleador = objIEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador",empleador);
        return "empleador";
    }

    @PutMapping
    public Empleador actualizarEmpleador(@RequestBody Empleador empleador){
        return objIEmpleadorService.actualizarEmpleador(empleador);
    }

    @DeleteMapping("/{idEmpleador}")
    public void eliminarEmpleadorPorId(@PathVariable int idEmpleador){objIEmpleadorService.eliminarEmpleadorPorId(idEmpleador);}
}
