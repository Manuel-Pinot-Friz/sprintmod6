package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Usuario;
import cl.awakelab.sprintmod6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objIUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objIUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(){
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        usuario.setFechaCreacion(LocalDateTime.now());
        objIUsuarioService.crearUsuario(usuario);
        return "listarUsuarios";
    }


    @GetMapping("/buscar/{idUsuario}")
    public String buscarUsuarioPorId(@PathVariable int idUsuario, Model model) {
        Usuario usuario = objIUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario",usuario);
        return "listarUsuarios";
    }


    @PostMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        model.addAttribute("usuario",objIUsuarioService.buscarUsuarioPorId(idUsuario));
        return "editarUsuario";
    }

    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, @PathVariable int idUsuario) {
        usuario.setFechaCreacion(LocalDate.from(LocalDateTime.now()));
        objIUsuarioService.actualizarUsuario(usuario, idUsuario);
        return "listarUsuarios";
    }

    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuarioPorId(@PathVariable int idUsuario) {
        objIUsuarioService.eliminarUsuarioPorId(idUsuario);
        return "listarUsuarios";
    }
}
