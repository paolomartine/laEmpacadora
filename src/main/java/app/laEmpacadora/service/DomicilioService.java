package app.laEmpacadora.service;

import app.laEmpacadora.entity.Domicilio;

import app.laEmpacadora.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    HashMap<String, Object> dato;
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public List<Domicilio> getDomicilios() {
        return this.domicilioRepository.findAll();
    }

    public ResponseEntity<Object> newDomicilio(Domicilio domicilio) {
        HashMap<String, Object> dato;
        dato = new HashMap<>();
        domicilioRepository.save(domicilio);
        dato.put("message", "Se guardó con éxito");
        dato.put("data", domicilio);
        return new ResponseEntity<>(domicilio, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deletedomicilio(Long id) {
        HashMap<String, Object> dato;
        dato = new HashMap<>();
        boolean existe = this.domicilioRepository.existsById(id);
        if (!existe) {
            dato.put("error", true);
            dato.put("mesagge", "No existe un domicilio con ese id");
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        domicilioRepository.deleteById(id);
        dato.put("mesagge", "Domicilio eliminado");
        return new ResponseEntity<>(
                dato,
                HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarDomicilioPorId(Long id) {
        dato = new HashMap<>();
        Optional<Domicilio> domicilioOptional = domicilioRepository.findById(id);
        if (domicilioOptional.isPresent()) {
            Domicilio domicilio = domicilioOptional.get();
            dato.put("message", "Domicilio encontrado");
            dato.put("data", domicilio);
            return new ResponseEntity<>(dato, HttpStatus.OK);
        } else {
            dato.put("error", true);
            dato.put("message", "No se encontró un domicilio con ese ID");
            return new ResponseEntity<>(dato, HttpStatus.NOT_FOUND);
        }
    }


}


