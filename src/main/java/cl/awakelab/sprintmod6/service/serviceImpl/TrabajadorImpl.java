package cl.awakelab.sprintmod6.service.serviceImpl;

import cl.awakelab.sprintmod6.entity.Trabajador;
import cl.awakelab.sprintmod6.repository.ITrabajadorRepository;
import cl.awakelab.sprintmod6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TrabajadorImpl implements ITrabajadorService {
    @Autowired
    ITrabajadorRepository objTrabajadorRepo;
    @Override
    public List<Trabajador> listarTrabajadores() {
        return objTrabajadorRepo.findAll();
    }

    @Override
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador) {
        return objTrabajadorRepo.findById(idTrabajador).orElseThrow(()->new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador) {
        Trabajador trabajador1 = this.buscarTrabajadorPorId(idTrabajador);
        trabajador1.setEmail(trabajador.getEmail());
        trabajador1.setNombre(trabajador.getNombre());
        trabajador1.setApellido1(trabajador.getApellido1());
        trabajador1.setApellido2(trabajador.getApellido2());
        trabajador1.setTelefono(trabajador.getTelefono());
        return objTrabajadorRepo.save(trabajador1);
    }

    @Override
    public void eliminarTrabajadorPorId(int idTrabajador) {
        objTrabajadorRepo.deleteById(idTrabajador);
    }
}
