package cl.awakelab.sprintmod6.restController;

import cl.awakelab.sprintmod6.entity.Usuario;
import cl.awakelab.sprintmod6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping{"api/usuario"}
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return objUsuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }

    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario){
        return objUsuarioService.actualizarUsuario(usuarioActualizar, idUsuario);
    }

    @PutMapping
    public Usuario actualizarUsuario2(@RequestBody Usuario usuarioActualizar){
        return objUsuarioService.actualizarUsuario(usuarioActualizar, idUsuario);
    }
}
