package app.laEmpacadora.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.laEmpacadora.entity.Producto;
import app.laEmpacadora.repository.ProductoRepository;

@Service
public class ProductoService {
    HashMap<String, Object> dato;
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProductos() {
        return this.productoRepository.findAll();
    }



    public ResponseEntity<Object> newProducto(Producto producto) {

        Optional<Producto> res = productoRepository.findProductoByNombre(producto.getNombre());

        dato = new HashMap<>();
        if (res.isPresent() && producto.getId() == null) {
            dato.put("error", true);
            dato.put("message", "ya existe un producto con ese nombre");
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        dato.put("message", "Se guardó con éxito");

        if (producto.getId() != null) {
            dato.put("message", "Se actualizó con éxito");

        }
        productoRepository.save(producto);
        dato.put("data", producto);

        return new ResponseEntity<>(
                dato,
                HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteproducto(Long id) {
        dato = new HashMap<>();
        boolean existe = this.productoRepository.existsById(id);
        if (!existe) {
            dato.put("error", true);
            dato.put("mesagge", "No existe un producto con ese id");
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        productoRepository.deleteById( id);
        dato.put("mesagge", "producto eliminado");
        return new ResponseEntity<>(
                dato,
                HttpStatus.ACCEPTED);
    }


    public ResponseEntity<Object> buscarProductoPorId(Long id) {
        dato = new HashMap<>();
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            dato.put("message", "Producto encontrado");
            dato.put("data", producto);
            return new ResponseEntity<>(dato, HttpStatus.OK);
        } else {
            dato.put("error", true);
            dato.put("message", "No se encontró un producto con ese ID");
            return new ResponseEntity<>(dato, HttpStatus.NOT_FOUND);
        }
    }

}

