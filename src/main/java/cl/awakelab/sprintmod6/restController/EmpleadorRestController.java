package cl.awakelab.sprintmod6.restController;

import cl.awakelab.sprintmod6.entity.Empleador;
import cl.awakelab.sprintmod6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/empleador", headers = "Accept=application/json")
public class EmpleadorRestController {
    @Autowired
    IEmpleadorService objIEmpleadorService;

    @GetMapping("/listaTrabajadores")
    public List<Empleador> listarEmpleadores() {
        return objIEmpleadorService.listarEmpleador();
    }

    @PostMapping("/crear")
    public Empleador crearEmpleador(@RequestBody Empleador empleador){
        return objIEmpleadorService.crearEmpleador(empleador);
    }

    @GetMapping("/{idEmpleador}")
    public Empleador buscarEmpleadorPorId(@PathVariable int idEmpleador) {
        return objIEmpleadorService.buscarEmpleadorPorId(idEmpleador);
    }

    @PostMapping("/actualizar/{idEmpleador}")
    public Empleador actualizarEmpleador(@RequestBody Empleador empleador, @PathVariable int idEmpleador) {
        return objIEmpleadorService.actualizarEmpleador(empleador, idEmpleador);
    }

    @DeleteMapping("/eliminar/{idEmpleador}")
    public void eliminarEmpleadorPorId(@PathVariable int idEmpleador) {objIEmpleadorService.eliminarEmpleadorPorId(idEmpleador);}

}