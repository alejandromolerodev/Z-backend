package zave.molerodev.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zave.molerodev.backend.entities.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findByUsuarioId(Long usuarioId); 
}
