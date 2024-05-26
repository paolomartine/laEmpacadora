package app.laEmpacadora.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.laEmpacadora.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.laEmpacadora.entity.DetallePedido;

@Service
public class DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public List<DetallePedido> getDetallePedidos() {
        return this.detallePedidoRepository.findAll();
    }

    public ResponseEntity<Object> newDetallePedido(DetallePedido detallePedido) {
        HashMap<String, Object> dato;
        dato = new HashMap<>();
        detallePedidoRepository.save(detallePedido);
        dato.put("message", "Se guardó con éxito");
        dato.put("data", detallePedido);
        return new ResponseEntity<>(detallePedido, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deletedetallePedido(Long id) {

        HashMap<String, Object> dato;
        dato = new HashMap<>();
        boolean existe = this.detallePedidoRepository.existsById(id);
        if (!existe) {
            dato.put("error", true);
            dato.put("mesagge", "No existe un detallepedido con ese id");
            return new ResponseEntity<>(dato, HttpStatus.CONFLICT);
        }
            detallePedidoRepository.deleteById( id);
            dato.put("mesagge", "detallePedido eliminado");
            return new ResponseEntity<>(dato, HttpStatus.ACCEPTED);
    }

    public List<Map<String, Object>> findProductosByPedidoId(Long pedidoId) {
        List<Map<String, Object>> productosConCantidad = new ArrayList<>();
        List<Object[]> productosRaw = detallePedidoRepository.findProductosByPedidoId(pedidoId);

        for (Object[] productoInfo : productosRaw) {
            Map<String, Object> productoConCantidad = new HashMap<>();
            productoConCantidad.put("id", productoInfo[0]);
            productoConCantidad.put("ingredientes", productoInfo[1]);
            productoConCantidad.put("nombre", productoInfo[2]);
            productoConCantidad.put("precio", productoInfo[3]);
            productoConCantidad.put("tiempoPreparacion", productoInfo[4]);
            productoConCantidad.put("url", productoInfo[5]);
            productoConCantidad.put("descripcion", productoInfo[6]);
            productoConCantidad.put("cantidad", productoInfo[7]);
            productosConCantidad.add(productoConCantidad);
        }
        return productosConCantidad;
    }
}