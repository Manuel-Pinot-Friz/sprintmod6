package cl.awakelab.sprintmod6.service;

import cl.awakelab.sprintmod6.entity.Perfil;

import java.util.List;

public interface IPerfilService {
    List<Perfil> listarPerfiles();
    Perfil crearPerfil(Perfil perfil);
    Perfil buscarPerfilPorId(int idPerfil);
    Perfil actualizarPerfil(Perfil perfil, int idPerfil);
    void eliminarPerfilPorId(int idPerfil);
}
