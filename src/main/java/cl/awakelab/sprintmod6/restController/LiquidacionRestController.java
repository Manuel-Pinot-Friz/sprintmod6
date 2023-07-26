package cl.awakelab.sprintmod6.restController;

import cl.awakelab.sprintmod6.entity.Liquidacion;
import cl.awakelab.sprintmod6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liquidacion")
public class LiquidacionRestController {
    @Autowired
    ILiquidacionService objLiquidacionService;

    @GetMapping
    public List<Liquidacion> listarLiquidaciones(){
        return objLiquidacionService.listarLiquidaciones();
    }
    @PostMapping("/crear")
    public Liquidacion crearLiquidacion(@RequestBody Liquidacion liquidacion){
        return objLiquidacionService.crearLiquidacion(liquidacion);
    }

    @GetMapping("/{idLiquidacion}")
    public Liquidacion buscarLiquidacionPorId(@PathVariable int idLiquidacion) {
        return objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
    }

    @PostMapping("/actualizar/{idLiquidacion}")
    public Liquidacion actualizarLiquidacion(@RequestBody Liquidacion liquidacion, @PathVariable int idLiquidacion) {
        return objLiquidacionService.actualizarLiquidacion(liquidacion, idLiquidacion);
    }

    @DeleteMapping("/eliminar/{idLiquidacion}")
    public void eliminarLiquidacionPorId(@PathVariable int idLiquidacion) {objLiquidacionService.eliminarLiquidacionPorId(idLiquidacion);}
}
