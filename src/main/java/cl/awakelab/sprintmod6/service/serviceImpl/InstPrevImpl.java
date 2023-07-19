package cl.awakelab.sprintmod6.service.serviceImpl;

import cl.awakelab.sprintmod6.entity.InstPrev;
import cl.awakelab.sprintmod6.repository.IInstPrevRepository;
import cl.awakelab.sprintmod6.service.IInstPrevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("instPrevImpl")
public class InstPrevImpl implements IInstPrevService {
    @Autowired
    IInstPrevRepository objInstPrevRepo;
    @Override
    public List<InstPrev> listarInstPrev() {
        return objInstPrevRepo.findAll();
    }

    @Override
    public InstPrev crearInstPrev(InstPrev instPrev) {
        return objInstPrevRepo.save(instPrev);
    }

    @Override
    public InstPrev buscarInstPrevPorId(int idInsPrev) {
        return objInstPrevRepo.findById(idInsPrev).orElseThrow(()->new NoSuchElementException("Institución no encontrada"));
    }

    @Override
    public InstPrev actualizarInstPrev(InstPrev instPrev, int idInsPrev) {
        InstPrev instPrev1 = this.buscarInstPrevPorId(idInsPrev);
        instPrev1.setDescripcion(instPrev.getDescripcion());
        instPrev1.setPorcDcto(instPrev.getPorcDcto());
        return objInstPrevRepo.save(instPrev1);
    }

    @Override
    public void eliminarInstPrevPorId(int idInsPrev) {
        objInstPrevRepo.deleteById(idInsPrev);
    }
}
