package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Empleador;
import cl.awakelab.sprintmod6.entity.Usuario;
import cl.awakelab.sprintmod6.service.IEmpleadorService;
import cl.awakelab.sprintmod6.service.IUsuarioService;
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

    @Autowired
    IUsuarioService objIUsuarioService;

    @GetMapping
    public String listarEmpleadores(Model model){
        List<Empleador> listaEmpleadores = objIEmpleadorService.listarEmpleador();
        model.addAttribute("empleadores",listaEmpleadores);
        return "listarEmpleadores";
    }

    @GetMapping("/crearEmpleador")
    public String mostrarFormularioCrearEmpleador(Model model) {
        model.addAttribute("usuarios", objIUsuarioService.listarUsuarios());
        return "crearEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador){
        Usuario usuario = new Usuario();
        usuario = objIUsuarioService.buscarUsuarioPorId(empleador.getUsuario().getIdUsuario());
        empleador.setUsuario(usuario);
        objIEmpleadorService.crearEmpleador(empleador);
        return "/crearEmpleador";
    }

    @GetMapping("/{idEmpleador}")
    public String buscarEmpleadorPorId(@PathVariable int idEmpleador, Model model){
        Empleador empleador = objIEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador",empleador);
        return "redirect:/empleador";
    }

    @PostMapping("/editar/{idEmpleador}")
    public String mostrarFormularioEditarEmpleador(@PathVariable int idEmpleador, Model model){
        model.addAttribute("empleador", objIEmpleadorService.buscarEmpleadorPorId(idEmpleador));
        model.addAttribute("usuarios", objIUsuarioService.listarUsuarios());
        return "editarEmpleador";
    }

    @PostMapping("/actualizar/{idEmpleador}")
    public String actualizarEmpleador(@ModelAttribute Empleador empleador, @PathVariable int idEmpleador){
        objIEmpleadorService.actualizarEmpleador(empleador, idEmpleador);
        return "redirect:/empleador";
    }

    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEmpleadorPorId(@PathVariable int idEmpleador){
        objIEmpleadorService.eliminarEmpleadorPorId(idEmpleador);
        return "redirect:/empleador";
    }
}
