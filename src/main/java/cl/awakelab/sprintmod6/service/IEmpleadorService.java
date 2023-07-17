package cl.awakelab.sprintmod6.service;

import cl.awakelab.sprintmod6.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {
    List<Empleador> listarEmpleador();
    Empleador crearEmpleador(Empleador empleador);
    Empleador buscarEmpleadorPorId(int idEmpleador);
    Empleador actualizarEmpleador(Empleador empleador);
    void eliminarEmpleadorPorId(int idEmpleador);
}
