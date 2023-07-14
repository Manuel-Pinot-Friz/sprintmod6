package cl.awakelab.sprintmod6.controller;

import cl.awakelab.sprintmod6.entity.Usuario;
import cl.awakelab.sprintmod6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String mostrarFormularioCrearUsuario(Model model){
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objIUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }


    @GetMapping("/{idUsuario}")
    public String buscarUsuarioPorId(@PathVariable int idUsuario, Model model) {
        Usuario usuario = objIUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario",usuario);
        return "usuario";
    }


    @GetMapping("/editar")
    public String mostrarFormularioEditarUsuario(Usuario usuario, Model model){
        Usuario usuarioAEditar = objIUsuarioService.buscarUsuarioPorId(usuario.getIdUsuario());
        model.addAttribute("usuario", usuarioAEditar);
        return "editarUsuario";
    }
    @PutMapping
    public String actualizarUsuario(@ModelAttribute Usuario usuario) {
        objIUsuarioService.actualizarUsuario(usuario);
        return "redirect/usuario";
    }


    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuarioPorId(@PathVariable int idUsuario) {objIUsuarioService.eliminarUsuarioPorId(idUsuario);}
}
