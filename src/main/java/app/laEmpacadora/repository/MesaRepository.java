package app.laEmpacadora.repository;

import app.laEmpacadora.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface MesaRepository extends JpaRepository<Mesa, Long> {
    Optional<Mesa> findMesaById(Long id);
}
