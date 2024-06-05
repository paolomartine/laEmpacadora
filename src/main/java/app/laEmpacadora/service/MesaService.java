package app.laEmpacadora.service;

import app.laEmpacadora.entity.Mesa;

import app.laEmpacadora.repository.MesaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MesaService {

    HashMap<String, Object> dato;
    private final MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }


    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public ResponseEntity<Object> newMesa(Mesa mesa) {

        Optional<Mesa> res = mesaRepository.findMesaById(mesa.getId());

        dato = new HashMap<>();
        if (res.isPresent() && mesa.getDisponibilidad() == true) {

            dato.put("disponible", true);
            dato.put("message", "Mesa disponible");
            mesaRepository.save(mesa);
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        dato.put("message", "Se guardó con éxito");

        if (mesa.getDisponibilidad() != true) {
            dato.put("message", "Se ocupó la mesa");

        }
        mesaRepository.save(mesa);
        dato.put("data", mesa);

        return new ResponseEntity<>(
                dato,
                HttpStatus.CREATED);
    }


    public ResponseEntity<Map<String, Object>> deleteMesa(Long id) {
        Map<String, Object> response = new HashMap<>();
        boolean exists = this.mesaRepository.existsById(id);
        if (!exists) {
            response.put("error", true);
            response.put("message", "No existe una mesa con ese id");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        this.mesaRepository.deleteById(id);
        response.put("message", "Mesa eliminada correctamente");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    public ResponseEntity<Object> buscarMesaPorId(Long id) {
        dato = new HashMap<>();
        Optional<Mesa> mesaOptional = mesaRepository.findById(id);
        if (mesaOptional.isPresent()) {
            Mesa mesa = mesaOptional.get();
            dato.put("message", "Mesa encontrada");
            dato.put("data", mesa);
            return new ResponseEntity<>(dato, HttpStatus.OK);
        } else {
            dato.put("error", true);
            dato.put("message", "No se encontró una mesa con ese ID");
            return new ResponseEntity<>(dato, HttpStatus.NOT_FOUND);
        }
    }


}