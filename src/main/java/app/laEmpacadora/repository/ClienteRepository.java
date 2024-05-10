package app.laEmpacadora.repository;

import app.laEmpacadora.entity.Cliente;
import app.laEmpacadora.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findClienteByContacto(String contacto);
}
