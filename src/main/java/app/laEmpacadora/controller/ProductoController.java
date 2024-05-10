package app.laEmpacadora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.laEmpacadora.entity.Producto;
import app.laEmpacadora.service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "api/v1/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Producto producto) {

        return this.productoService.newProducto(producto);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto) {

        return this.productoService.newProducto(producto);
    }

    @DeleteMapping(path = "{productoId}")
    public ResponseEntity<Object> eliminarProducto(@PathVariable("productoId") Long id) {
        return this.productoService.deleteproducto(id);
    }


}
