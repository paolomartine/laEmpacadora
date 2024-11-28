package app.laEmpacadora.repository;

import app.laEmpacadora.entity.Domicilio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface DomicilioRepository extends JpaRepository<Domicilio, Long>{
    Optional<Domicilio> findDomicilioById(Long id);
    List<Domicilio> findByBorradoFalse(); // Método para obtener solo domicilios no borrados
}

