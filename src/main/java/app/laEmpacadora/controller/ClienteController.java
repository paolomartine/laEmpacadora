package app.laEmpacadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import app.laEmpacadora.entity.Cliente;
import app.laEmpacadora.entity.Producto;
import app.laEmpacadora.service.ClienteService;
import app.laEmpacadora.service.ProductoService;


@RestController
@RequestMapping(path = "api/v1/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping
    public ResponseEntity<Object> registrarCliente(@RequestBody Cliente cliente) {

        return this.clienteService.newCliente(cliente);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cliente) {

        return this.clienteService.newCliente(cliente);
    }

    @DeleteMapping(path = "{clienteId}")
    public ResponseEntity<Object> eliminarcliente(@PathVariable("clienteId") Long id) {

        return this.clienteService.deleteCliente(id);
    }


}
