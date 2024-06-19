package app.laEmpacadora.controller;

import app.laEmpacadora.entity.DetallePedidoDom;
import app.laEmpacadora.service.DetallePedidoDomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



    @RestController
    @RequestMapping(path = "api/v1/detallepedidosdom")
    @CrossOrigin(origins = "http://localhost:3000")
    public class DetallePedidoDomController {

        private final DetallePedidoDomService detallePedidoDomService;

        @Autowired
        public DetallePedidoDomController(DetallePedidoDomService detallePedidoDomService) {
            this.detallePedidoDomService = detallePedidoDomService;
        }

        @GetMapping
        public List<DetallePedidoDom> getDetallePedidosDom() {
            return detallePedidoDomService.getDetallePedidosDom();
        }

        @PostMapping
        public ResponseEntity<Object> registrarDetallePedidoDom(@RequestBody DetallePedidoDom detallePedidoDom) {

            return this.detallePedidoDomService.newDetallePedidoDom(detallePedidoDom);
        }

        @PutMapping
        public ResponseEntity<Object> actualizarDetallePedidoDom(@RequestBody DetallePedidoDom detallePedidoDom) {
            return this.detallePedidoDomService.newDetallePedidoDom(detallePedidoDom);
        }

        @DeleteMapping(path = "{detallepedidodomId}")
        public ResponseEntity<Object> eliminarDetallePedidoDom(@PathVariable("detallepedidodomId") Long id) {
            return this.detallePedidoDomService.deletedetallePedidoDom(id);
        }

        @GetMapping("/{domicilioId}/productos")
        public ResponseEntity<List<Map<String, Object>>> getProductosByDomicilioId(@PathVariable("DomicilioId") Long domicilioId) {
            List<Map<String, Object>> productos = detallePedidoDomService.findProductosByDomicilioId(domicilioId);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }

    }
