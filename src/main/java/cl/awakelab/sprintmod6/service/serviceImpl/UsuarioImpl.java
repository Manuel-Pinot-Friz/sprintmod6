package cl.awakelab.sprintmod6.service.serviceImpl;

import cl.awakelab.sprintmod6.entity.Usuario;
import cl.awakelab.sprintmod6.repository.IUsuarioRepository;
import cl.awakelab.sprintmod6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objIUsuarioRepo;
    @Override
    public List<Usuario> listarUsuarios() {
        return objIUsuarioRepo.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objIUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) {
        return objIUsuarioRepo.findById(idUsuario).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));

    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario, int idUsuario) {
        Usuario usuario1 = this.buscarUsuarioPorId(idUsuario);
        usuario1.setFechaCreacion(usuario.getFechaCreacion());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setNombre(usuario.getNombre());
        usuario1.setApellido1(usuario.getApellido1());
        usuario1.setApellido2(usuario.getApellido2());
        usuario1.setTelefono(usuario.getTelefono());
        usuario1.setPerfil(usuario.getPerfil());
        return objIUsuarioRepo.save(usuario1);
    }

    @Override
    public void eliminarUsuarioPorId(int idUsuario) {
        objIUsuarioRepo.deleteById(idUsuario);
    }
}
