package app.laEmpacadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.laEmpacadora.entity.Producto;

import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    Optional<Producto> findProductoByNombre(String nombre);

}
