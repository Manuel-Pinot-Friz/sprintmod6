package cl.awakelab.sprintmod6.service;

import cl.awakelab.sprintmod6.entity.Empleador;
import cl.awakelab.sprintmod6.entity.InstPrev;

import java.util.List;

public interface IInstPrevService {
    List<InstPrev> listarInstPrev();
    InstPrev crearInstPrev(InstPrev instPrev);
    InstPrev buscarInstPrevPorId(int idInstPrev);
    InstPrev actualizarInstPrev(InstPrev instPrev, int idInsPrev);
    void eliminarInstPrevPorId(int idInsPrev);

}