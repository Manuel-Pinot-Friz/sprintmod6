package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Liquidacion;
import cl.awakelab.sprintmod6.service.ILiquidacionService;
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

    @GetMapping
    public String listarLiquidaciones(Model model) {
        List<Liquidacion> listaLiquidaciones = objILiquidacionService.listarLiquidaciones();
        model.addAttribute("liquidaciones", listaLiquidaciones);
        return "listarLiquidaciones";
    }

    @PostMapping("/crearLiquidacion")
    public Liquidacion crearLiquidacion(@RequestBody Liquidacion liquidacion){
        return objILiquidacionService.crearLiquidacion(liquidacion);
    }


    @GetMapping("/{idLiquidacion}")
    public String buscarLiquidacionPorId(@PathVariable long idLiquidacion, Model model) {
        Liquidacion liquidacion = objILiquidacionService.buscarLiquidacionPorId(idLiquidacion);
        model.addAttribute("liquidacion",liquidacion);
        return "liquidacion";
    }


    @PutMapping
    public Liquidacion actualizarLiquidacion(@RequestBody Liquidacion liquidacion) {
        return objILiquidacionService.actualizarLiquidacion(liquidacion);
    }


    @DeleteMapping("/{idLiquidacion}")
    public void eliminarLiquidacionPorId(@PathVariable long idLiquidacion) {objILiquidacionService.eliminarLiquidacionPorId(idLiquidacion);}

}
