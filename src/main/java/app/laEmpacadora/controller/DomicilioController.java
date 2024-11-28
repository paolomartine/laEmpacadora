package app.laEmpacadora.controller;

import app.laEmpacadora.entity.Domicilio;
import app.laEmpacadora.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping(path = "api/v1/domicilios")
    @CrossOrigin(origins = "http://localhost:3000")
    public class DomicilioController {
        private final DomicilioService domicilioService;

        @Autowired
        public DomicilioController(DomicilioService domicilioService) {
            this.domicilioService = domicilioService;
        }

        @GetMapping
        public List<Domicilio> getDomicilios() {
            return domicilioService.getDomicilios();
        }

        @PostMapping
        public ResponseEntity<Object> registrarDomicilio(@RequestBody Domicilio domicilio) {

            return this.domicilioService.newDomicilio(domicilio);
        }

        @PutMapping
        public ResponseEntity<Object> actualizarDomicilio(@RequestBody Domicilio domicilio) {

            return this.domicilioService.newDomicilio(domicilio);
        }

        @DeleteMapping(path = "{domicilioId}")
        public ResponseEntity<Object> eliminarDomicilio(@PathVariable("domicilioId") Long id) {

            return this.domicilioService.deletedomicilio(id);
        }

        @GetMapping(path = "{domicilioId}")
        public ResponseEntity<Object> buscarDomicilioPorId(@PathVariable("domicilioId") Long id) {
            return this.domicilioService.buscarDomicilioPorId(id);
        }
        // Usamos PUT para el borrado lógico
        @PutMapping(path = "{domicilioId}/borrar")
        public ResponseEntity<Object> borrarLogicoDomicilio(@PathVariable("domicilioId") Long id) {
            return this.domicilioService.borrarLogicoDomicilio(id); // Llamar al servicio para marcar como borrado
        }

}
