package app.laEmpacadora.controller;

import java.util.List;

import app.laEmpacadora.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
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

}
