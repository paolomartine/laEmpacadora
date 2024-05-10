package app.laEmpacadora.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import app.laEmpacadora.entity.Producto;
import app.laEmpacadora.repository.PedidoRepository;
import app.laEmpacadora.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.laEmpacadora.entity.EnumEstado;
import app.laEmpacadora.entity.Pedido;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getPedidos() {
        return this.pedidoRepository.findAll();
    }

    public ResponseEntity<Object> newPedido(Pedido pedido) {
        HashMap<String, Object> dato;
        dato = new HashMap<>();
        pedidoRepository.save(pedido);
        dato.put("message", "se guardó con éxito");
        dato.put("data", pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deletepedido(Long id) {
        HashMap<String, Object> dato;
        dato = new HashMap<>();
        boolean existe = this.pedidoRepository.existsById(id);
        if (!existe) {
            dato.put("error", true);
            dato.put("mesagge", "No existe un pedido con ese id");
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        pedidoRepository.deleteById(id);
        dato.put("mesagge", "pedido eliminado");
        return new ResponseEntity<>(
                dato,
                HttpStatus.ACCEPTED);
    }

}

