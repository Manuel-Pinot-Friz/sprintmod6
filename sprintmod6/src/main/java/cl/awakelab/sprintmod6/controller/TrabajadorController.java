package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Trabajador;
import cl.awakelab.sprintmod6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    ITrabajadorService objITrabajadorService;

    @GetMapping
    public String listarTrabajadores(Model model) {
        List<Trabajador> listaTrabajadores = objITrabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", listaTrabajadores);
        return "listarTrabajadores";
    }

    @PostMapping("/crearTrabajador")
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador){
        return objITrabajadorService.crearTrabajador(trabajador);
    }


    @GetMapping("/{idTrabajador}")
    public String buscarTrabajadorPorId(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajador = objITrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador",trabajador);
        return "trabajador";
    }


    @PutMapping
    public Trabajador actualizarTrabajador(@RequestBody Trabajador trabajador) {
        return objITrabajadorService.actualizarTrabajador(trabajador);
    }


    @DeleteMapping("/{idTrabajador}")
    public void eliminarTrabajadorPorId(@PathVariable int idTrabajador) {objITrabajadorService.eliminarTrabajadorPorId(idTrabajador);}

}
