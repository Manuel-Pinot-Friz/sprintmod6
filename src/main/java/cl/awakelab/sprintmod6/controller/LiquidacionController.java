package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Liquidacion;
import cl.awakelab.sprintmod6.service.IInstPrevService;
import cl.awakelab.sprintmod6.service.IInstitucionSaludService;
import cl.awakelab.sprintmod6.service.ILiquidacionService;
import cl.awakelab.sprintmod6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {
    @Autowired
    ILiquidacionService objILiquidacionService;
    @Autowired
    ITrabajadorService objITrabajadorService;
    @Autowired
    IInstPrevService objIInstitucionPrevision;
    @Autowired
    IInstitucionSaludService objIInstitucionSalud;

    @GetMapping
    public String listarLiquidaciones(Model model) {
        List<Liquidacion> listaLiquidaciones = objILiquidacionService.listarLiquidaciones();
        model.addAttribute("liquidaciones", listaLiquidaciones);
        return "listarLiquidaciones";
    }
    //    @GetMapping("/crearLiquidacion")
//    public String mostrarFormularioCrearLiquidacion(){return "crearLiquidacion";}
    @GetMapping("/crearLiquidacion")
    public String mostrarFormularioCrearLiquidacion(Model model){
        model.addAttribute("trabajadores", objITrabajadorService.listarTrabajadores());
        model.addAttribute("listaInstSalud", objIInstitucionSalud.listarInstitucionSalud());
        model.addAttribute("listaInstPrevision", objIInstitucionPrevision.listarInstPrev());
        return "crearLiquidacion";
    }

    @PostMapping("/crearLiquidacion")
    public String crearLiquidacion(@ModelAttribute Liquidacion liquidacion){
        objILiquidacionService.crearLiquidacion(liquidacion);
        return "redirect:/liquidacion";
    }

    @GetMapping("/{idLiquidacion}")
    public String buscarLiquidacionPorId(@PathVariable long idLiquidacion, Model model) {
        Liquidacion liquidacion = objILiquidacionService.buscarLiquidacionPorId(idLiquidacion);
        model.addAttribute("liquidacion",liquidacion);
        return "redirect:/liquidacion";
    }

    @PostMapping("/editar/{idLiquidacion}")
    public String mostrarFormularioEditarLiquidacion(@PathVariable long idLiquidacion, Model model){
        model.addAttribute("liquidacion", objILiquidacionService.buscarLiquidacionPorId(idLiquidacion));
        model.addAttribute("trabajadores", objITrabajadorService.listarTrabajadores());
        model.addAttribute("listaInstSalud", objIInstitucionSalud.listarInstitucionSalud());
        model.addAttribute("listaInstPrevision", objIInstitucionPrevision.listarInstPrev());
        return "editarLiquidacion";
    }
    //Todo: revisar duplica no actualiza
    @PostMapping("/actualizar/{idLiquidacion}")
    public String actualizarLiquidacion(@ModelAttribute Liquidacion liquidacion, @PathVariable long idLiquidacion) {
        objILiquidacionService.actualizarLiquidacion(liquidacion, idLiquidacion);
        return "redirect:/liquidacion";
    }

    @PostMapping("/eliminar/{idLiquidacion}")
    public String eliminarLiquidacionPorId(@PathVariable long idLiquidacion) {
        objILiquidacionService.eliminarLiquidacionPorId(idLiquidacion);
        return "redirect:/liquidacion";
    }

}