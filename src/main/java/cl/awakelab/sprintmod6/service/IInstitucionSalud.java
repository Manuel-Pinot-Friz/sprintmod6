package cl.awakelab.sprintmod6.service;

import cl.awakelab.sprintmod6.entity.InstitucionSalud;
import java.util.List;

public interface IInstitucionSalud {
    List<InstitucionSalud> listarInstitucionSalud();
    InstitucionSalud crearInstitucionSalud(InstitucionSalud institucionSalud);
    InstitucionSalud buscarInstitucionSaludPorId(int idInstitucionSalud);
    InstitucionSalud actualizarInstitucionSalud(InstitucionSalud institucionSalud);
    void eliminarInstitucionSaludPorId(int idInstitucionSalud);
}
