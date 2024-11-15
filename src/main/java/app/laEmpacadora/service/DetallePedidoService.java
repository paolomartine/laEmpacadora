package app.laEmpacadora.service;

import java.util.*;

import app.laEmpacadora.entity.EnumEstado;
import app.laEmpacadora.entity.Producto;
import app.laEmpacadora.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.laEmpacadora.entity.DetallePedido;

@Service
public class DetallePedidoService {
    HashMap<String, Object> dato;

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
            productoConCantidad.put("precio", productoInfo[1]); //precio
            productoConCantidad.put("descripcion", productoInfo[2]); //descripcion
            productoConCantidad.put("nombre", productoInfo[3]); //nombre
            productoConCantidad.put("url", productoInfo[4]);
            productoConCantidad.put("cantidad", productoInfo[5]);
            productoConCantidad.put("observacion", productoInfo[6]); // observación del detalle del pedido
            productoConCantidad.put("estadoDetalle",productoInfo[7]);//estado del detalle del pedido
            productosConCantidad.add(productoConCantidad);
        }
        return productosConCantidad;
    }

   /* public boolean actualizarEstadoDetalleProducto(Long pedidoId, Long productoId, String nuevoEstado) {
        Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findByIdAndPedidoId(productoId, pedidoId);

        if (detallePedidoOptional.isPresent()) {
            DetallePedido detallePedido = detallePedidoOptional.get();
            detallePedido.setEstadoDetalle(EnumEstado.valueOf(nuevoEstado));  // Actualizar el estado a "DESPACHADO"
            detallePedidoRepository.save(detallePedido);  // Guardar los cambios
            return true;
        }
        return false;
    }*/

    public ResponseEntity<Object> actualizarEstadoDetalle(Long id, EnumEstado nuevoEstado) {
        Optional<DetallePedido> detallePedidoOpt = detallePedidoRepository.findById(id);
        if (detallePedidoOpt.isPresent()) {
            DetallePedido detallePedido = detallePedidoOpt.get();
            detallePedido.setEstadoDetalle(nuevoEstado);
            detallePedidoRepository.save(detallePedido);
            return new ResponseEntity<>(detallePedido, HttpStatus.OK);
        } else {
            HashMap<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("message", "DetallePedido no encontrado");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

}