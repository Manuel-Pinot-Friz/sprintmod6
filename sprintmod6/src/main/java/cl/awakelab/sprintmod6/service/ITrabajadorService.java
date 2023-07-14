package cl.awakelab.sprintmod6.service;

import cl.awakelab.sprintmod6.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    List<Trabajador> listarTrabajadores();
    Trabajador crearTrabajador(Trabajador trabajador);
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    Trabajador actualizarTrabajador(Trabajador trabajador);
    void eliminarTrabajadorPorId(int idTrabajador);
}
