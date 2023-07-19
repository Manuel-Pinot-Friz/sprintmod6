package cl.awakelab.sprintmod6.service.serviceImpl;

import cl.awakelab.sprintmod6.entity.Liquidacion;
import cl.awakelab.sprintmod6.repository.ILiquidacionRepository;
import cl.awakelab.sprintmod6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {
    @Autowired
    ILiquidacionRepository objLiquidacionRepo;
    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objLiquidacionRepo.findAll();
    }

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public Liquidacion buscarLiquidacionPorId(long idLiquidacion) {
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(()->new NoSuchElementException("Liquidación no encontrada"));
    }

    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacion, long idLiquidacion) {
        Liquidacion liquidacion1 = this.buscarLiquidacionPorId(idLiquidacion);
        liquidacion1.setAnticipo(liquidacion.getAnticipo());
        liquidacion1.setPeriodo(liquidacion.getPeriodo());
        liquidacion1.setSueldoImponible(liquidacion.getSueldoImponible());
        liquidacion1.setSueldoLiquido(liquidacion.getSueldoLiquido());
        liquidacion1.setMontoInstSalud(liquidacion.getMontoInstSalud());
        liquidacion1.setInstPrevisional(liquidacion.getInstPrevisional());
        liquidacion1.setTotalHaberes(liquidacion.getTotalHaberes());
        liquidacion1.setTotalDescuento(liquidacion.getTotalDescuento());
        return objLiquidacionRepo.save(liquidacion1);
    }

    @Override
    public void eliminarLiquidacionPorId(long idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);
    }
}
