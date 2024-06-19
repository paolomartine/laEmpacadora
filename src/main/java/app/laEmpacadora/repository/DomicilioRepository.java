package app.laEmpacadora.repository;

import app.laEmpacadora.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long>{
}

