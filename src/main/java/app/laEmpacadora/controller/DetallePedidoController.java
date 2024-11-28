package app.laEmpacadora.controller;

import java.util.List;
import java.util.Map;

import app.laEmpacadora.entity.EnumEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.laEmpacadora.entity.DetallePedido;
import app.laEmpacadora.service.DetallePedidoService;

@RestController
@RequestMapping(path = "api/v1/detallepedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    @Autowired
    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public List<DetallePedido> getDetallePedidos() {
        return detallePedidoService.getDetallePedidos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarDetallePedido(@RequestBody DetallePedido detallePedido) {

        return this.detallePedidoService.newDetallePedido(detallePedido);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarDetallePedido(@RequestBody DetallePedido detallePedido) {
        return this.detallePedidoService.newDetallePedido(detallePedido);
    }


    @DeleteMapping(path = "{detallepedidoId}")
    public ResponseEntity<Object> eliminarDetallePedido(@PathVariable("detallepedidoId") Long id) {
        return this.detallePedidoService.deletedetallePedido(id);
    }

    @GetMapping("/{pedidoId}/productos")
    public ResponseEntity<List<Map<String, Object>>> getProductosByPedidoId(@PathVariable("pedidoId") Long pedidoId) {
        List<Map<String, Object>> productos = detallePedidoService.findProductosByPedidoId(pedidoId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Object> actualizarEstadoDetalle(
            @PathVariable("id") Long id,
            @RequestParam("estadoDetalle") EnumEstado nuevoEstado) {
        return detallePedidoService.actualizarEstadoDetalle(id, nuevoEstado);
    }

}




