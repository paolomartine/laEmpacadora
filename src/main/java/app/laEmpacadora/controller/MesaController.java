package app.laEmpacadora.controller;

import app.laEmpacadora.entity.Mesa;

import app.laEmpacadora.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "api/v1/mesas")
@CrossOrigin(origins = "http://localhost:3000")
public class MesaController {
    private final MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public List<Mesa> getMesas() {
        return mesaService.getAllMesas();
    }

    @PostMapping
    public ResponseEntity<Object> registrarMesa(@RequestBody Mesa mesa) {

        return this.mesaService.newMesa(mesa);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarMesa( @RequestBody Mesa mesa) {
        return this.mesaService.newMesa(mesa);

    }

     @DeleteMapping(path = "{mesaId}")
     public ResponseEntity<Map<String, Object>> eliminarMesa(@PathVariable("mesaId") Long id) {
         return this.mesaService.deleteMesa(id);
     }

    @GetMapping(path = "{mesaId}")
    public ResponseEntity<Object> buscarMesaPorId(@PathVariable("mesaId") Long id) {
        return this.mesaService.buscarMesaPorId(id);
    }

    @PutMapping(path = "{mesaId}/disponibilidad")
    public ResponseEntity<Object> actualizarDisponibilidad(@PathVariable("mesaId") Long mesaId, @RequestBody Map<String, Boolean> disponibilidad) {
        // Recibimos un Map con la clave "disponibilidad" y su valor (true/false)
        Boolean disponibilidadValue = disponibilidad.get("disponibilidad");
        if (disponibilidadValue == null) {
            return ResponseEntity.badRequest().body("El campo 'disponibilidad' es requerido.");
        }

        // Llamamos al servicio para actualizar solo la disponibilidad
        return this.mesaService.actualizarDisponibilidad(mesaId, disponibilidadValue);
    }

}
