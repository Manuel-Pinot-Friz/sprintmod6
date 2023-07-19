package cl.awakelab.sprintmod6.repository;

import cl.awakelab.sprintmod6.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
