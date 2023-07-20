package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Trabajador;
import cl.awakelab.sprintmod6.service.IEmpleadorService;
import cl.awakelab.sprintmod6.service.IInstPrevService;
import cl.awakelab.sprintmod6.service.IInstitucionSaludService;
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
    @Autowired
    IInstitucionSaludService objIInstitucionSaludService;
    @Autowired
    IInstPrevService objIInstitucionPrevisionService;
    @Autowired
    IEmpleadorService objIEmpleadorService;

    @GetMapping
    public String listarTrabajadores(Model model) {
        List<Trabajador> listaTrabajadores = objITrabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", listaTrabajadores);
        return "listarTrabajadores";
    }

    @GetMapping("/crearTrabajador")
    public String mostrarFormularioCrearTrabajador(Model model){
        model.addAttribute("listaInstSalud", objIInstitucionSaludService.listarInstitucionSalud());
        model.addAttribute("listaInstPrevision", objIInstitucionPrevisionService.listarInstPrev());
        model.addAttribute("empleadores", objIEmpleadorService.listarEmpleador());
        return "crearTrabajador";
    }
    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador){
        objITrabajadorService.crearTrabajador(trabajador);
        return "redirect:/trabajador";
    }


    @GetMapping("/{idTrabajador}")
    public String buscarTrabajadorPorId(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajador = objITrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador",trabajador);
        return "redirect:/trabajador";
    }

    @PostMapping("/editar/{idTrabajador}")
    public String mostrarFormularioEditarTrabajador(@PathVariable int idTrabajador, Model model){
        model.addAttribute("empleadores", objIEmpleadorService.listarEmpleador());
        model.addAttribute("trabajador", objITrabajadorService.buscarTrabajadorPorId(idTrabajador));
        model.addAttribute("listaInstSalud", objIInstitucionSaludService.listarInstitucionSalud());
        model.addAttribute("listaInstPrevision", objIInstitucionPrevisionService.listarInstPrev());
        return "editarTrabajador";
    }

    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador) {
        objITrabajadorService.actualizarTrabajador(trabajador, idTrabajador);
        return "redirect:/trabajador";
    }


    @PostMapping("/eliminar/{idTrabajador}")
    public String eliminarTrabajadorPorId(@PathVariable int idTrabajador) {
        objITrabajadorService.eliminarTrabajadorPorId(idTrabajador);
        return "redirect:/trabajador";
    }

}