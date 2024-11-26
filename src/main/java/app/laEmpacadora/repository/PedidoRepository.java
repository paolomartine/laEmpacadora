package app.laEmpacadora.repository;

import app.laEmpacadora.entity.Pedido;
import app.laEmpacadora.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findPedidoById(Long id);
    List<Pedido> findByBorradoFalse(); // Método para obtener solo pedidos no borrados
}
