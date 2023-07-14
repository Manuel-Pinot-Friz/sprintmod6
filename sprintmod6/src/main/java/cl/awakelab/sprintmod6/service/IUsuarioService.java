package cl.awakelab.sprintmod6.service;

import cl.awakelab.sprintmod6.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();

    Usuario crearUsuario(Usuario usuario);

    Usuario buscarUsuarioPorId(int idUsuario);

    Usuario actualizarUsuario(Usuario usuario);

    void eliminarUsuarioPorId(int idUsuario);
}
