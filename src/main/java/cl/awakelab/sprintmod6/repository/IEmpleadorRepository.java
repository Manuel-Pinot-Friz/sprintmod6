package cl.awakelab.sprintmod6.repository;

import cl.awakelab.sprintmod6.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {
}
