package cl.awakelab.sprintmod6.service.serviceImpl;

import cl.awakelab.sprintmod6.entity.InstitucionSalud;
import cl.awakelab.sprintmod6.repository.IInstitucionSaludRepository;
import cl.awakelab.sprintmod6.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("institucionSaludImpl")
public class InstitucionSaludImpl implements IInstitucionSaludService {
    @Autowired
    IInstitucionSaludRepository objIInstSaludRepository;
    @Override
    public List<InstitucionSalud> listarInstitucionSalud() {
        return objIInstSaludRepository.findAll();
    }

}
