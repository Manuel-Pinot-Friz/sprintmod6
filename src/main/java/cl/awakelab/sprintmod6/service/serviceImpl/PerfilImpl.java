package cl.awakelab.sprintmod6.service.serviceImpl;

import cl.awakelab.sprintmod6.entity.Perfil;
import cl.awakelab.sprintmod6.repository.IPerfilRepository;
import cl.awakelab.sprintmod6.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("perfilImpl")
public class PerfilImpl implements IPerfilService {
    @Autowired
    IPerfilRepository objPerfilRepo;
    @Override
    public List<Perfil> listarPerfiles() {
        return objPerfilRepo.findAll();
    }

    @Override
    public Perfil crearPerfil(Perfil perfil) {
        return objPerfilRepo.save(perfil);
    }

    @Override
    public Perfil buscarPerfilPorId(int idPerfil) {
        return objPerfilRepo.findById(idPerfil).orElseThrow(()->new NoSuchElementException("Perfil no encontrado"));
    }

    @Override
    public Perfil actualizarPerfil(Perfil perfil, int idPerfil) {
        Perfil perfil1 = this.buscarPerfilPorId(idPerfil);
        perfil1.setDescripcion(perfil.getDescripcion());
        perfil1.setEstado(perfil.isEstado());
        return objPerfilRepo.save(perfil1);
    }

    @Override
    public void eliminarPerfilPorId(int idPerfil) {
        objPerfilRepo.deleteById(idPerfil);
    }
}
