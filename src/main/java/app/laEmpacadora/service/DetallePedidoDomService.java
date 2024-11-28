package app.laEmpacadora.service;

import app.laEmpacadora.entity.DetallePedido;
import app.laEmpacadora.entity.DetallePedidoDom;
import app.laEmpacadora.entity.EnumEstado;
import app.laEmpacadora.repository.DetallePedidoDomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DetallePedidoDomService {

    private final DetallePedidoDomRepository detallePedidoDomRepository;

    @Autowired
    public DetallePedidoDomService(DetallePedidoDomRepository detallePedidoDomRepository) {
        this.detallePedidoDomRepository = detallePedidoDomRepository;
    }

    public List<DetallePedidoDom> getDetallePedidosDom() {
        return this.detallePedidoDomRepository.findAll();
    }

    public ResponseEntity<Object> newDetallePedidoDom(DetallePedidoDom detallePedidoDom) {
        HashMap<String, Object> dato;
        dato = new HashMap<>();
        detallePedidoDomRepository.save(detallePedidoDom);
        dato.put("message", "Se guardó con éxito");
        dato.put("data", detallePedidoDom);
        return new ResponseEntity<>(detallePedidoDom, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deletedetallePedidoDom(Long id) {

        HashMap<String, Object> dato;
        dato = new HashMap<>();
        boolean existe = this.detallePedidoDomRepository.existsById(id);
        if (!existe) {
            dato.put("error", true);
            dato.put("mesagge", "No existe un detallepedidodom con ese id");
            return new ResponseEntity<>(dato, HttpStatus.CONFLICT);
        }
        detallePedidoDomRepository.deleteById( id);
        dato.put("mesagge", "detallePedidoDom eliminado");
        return new ResponseEntity<>(dato, HttpStatus.ACCEPTED);
    }

    public List<Map<String, Object>> findProductosByDomicilioId(Long domicilioId) {
        List<Map<String, Object>> productosConCantidad = new ArrayList<>();
        List<Object[]> productosRaw = detallePedidoDomRepository.findProductosByDomicilioId(domicilioId);

        for (Object[] productoInfo : productosRaw) {
            Map<String, Object> productoConCantidad = new HashMap<>();
            productoConCantidad.put("id", productoInfo[0]);
            productoConCantidad.put("precio", productoInfo[1]); //precio
            productoConCantidad.put("descripcion", productoInfo[2]); //descripcion
            productoConCantidad.put("nombre", productoInfo[3]); //nombre
            productoConCantidad.put("url", productoInfo[4]);
            productoConCantidad.put("cantidad", productoInfo[5]);
            productoConCantidad.put("observacion", productoInfo[6]); // observación del detalle del pedido
            productoConCantidad.put("estado", productoInfo[7]);
            productosConCantidad.add(productoConCantidad);
        }
        return productosConCantidad;
    }


    public ResponseEntity<Object> actualizarEstadoDetalleDom(Long id, EnumEstado nuevoEstado) {
        Optional<DetallePedidoDom> detallePedidoDomOpt = detallePedidoDomRepository.findById(id);
        if (detallePedidoDomOpt.isPresent()) {
            DetallePedidoDom detallePedidoDom = detallePedidoDomOpt.get();
            detallePedidoDom.setEstado(nuevoEstado);
            detallePedidoDomRepository.save(detallePedidoDom);
            return new ResponseEntity<>(detallePedidoDom, HttpStatus.OK);
        } else {
            HashMap<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("message", "DetallePedidoDom no encontrado");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}