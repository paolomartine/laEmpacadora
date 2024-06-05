package app.laEmpacadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.laEmpacadora.entity.Pedido;
import app.laEmpacadora.entity.Producto;
import app.laEmpacadora.service.PedidoService;
import app.laEmpacadora.service.ProductoService;


@RestController
@RequestMapping(path = "api/v1/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoService.getPedidos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarPedido(@RequestBody Pedido pedido) {

        return this.pedidoService.newPedido(pedido);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarPedido(@RequestBody Pedido pedido) {

        return this.pedidoService.newPedido(pedido);
    }

    @DeleteMapping(path = "{pedidoId}")
    public ResponseEntity<Object> eliminarPedido(@PathVariable("pedidoId") Long id) {

        return this.pedidoService.deletepedido(id);
    }

    @GetMapping(path = "{pedidoId}")
    public ResponseEntity<Object> buscarPedidoPorId(@PathVariable("pedidoId") Long id) {
        return this.pedidoService.buscarPedidoPorId(id);
    }
}
