package cl.awakelab.sprintmod6.restController;

import cl.awakelab.sprintmod6.entity.Trabajador;
import cl.awakelab.sprintmod6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping(value = "/api/trabajador",headers = "Accept=application/json")
public class TrabajadorRestController {

    @Autowired
    ITrabajadorService objITrabajadorService;

    @GetMapping("/listaTrabajadores")
    public List<Trabajador> listarTrabajadores() {
        return objITrabajadorService.listarTrabajadores();
    }

    @PostMapping("/crear")
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador){
        return objITrabajadorService.crearTrabajador(trabajador);
    }

    @GetMapping("/buscar/{idTrabajador}")
    public Trabajador buscarTrabajadorPorId(@PathVariable int idTrabajador) {
        return objITrabajadorService.buscarTrabajadorPorId(idTrabajador);
    }

    @PostMapping("/actualizar/{idTrabajador}")
    public Trabajador actualizarTrabajador(@RequestBody Trabajador trabajador, @PathVariable int idTrabajador) {
        return objITrabajadorService.actualizarTrabajador(trabajador, idTrabajador);
    }

    @DeleteMapping("/eliminar/{idTrabajador}")
    public void eliminarTrabajadorPorId(@PathVariable int idTrabajador) {objITrabajadorService.eliminarTrabajadorPorId(idTrabajador);}
}