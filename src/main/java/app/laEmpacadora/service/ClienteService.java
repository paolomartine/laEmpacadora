package app.laEmpacadora.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import app.laEmpacadora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.laEmpacadora.entity.Cliente;

@Service
public class ClienteService {
    HashMap<String, Object> dato;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }

    public ResponseEntity<Object> newCliente(Cliente cliente) {

    Optional<Cliente> ban= clienteRepository.findClienteByContacto(cliente.getContacto());

        dato = new HashMap<>();
        if (ban.isPresent() && cliente.getId() == null) {
            dato.put("error", true);
            dato.put("message", "Ya existe un cliente con ese contacto");
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        dato.put("message", "Se guardó con éxito");

        if (cliente.getContacto() != null) {
            dato.put("message", "Se actualizó con éxito");

        }
        clienteRepository.save(cliente);
        dato.put("data", cliente);

        return new ResponseEntity<>(
                dato,
                HttpStatus.CREATED);
    }


    public ResponseEntity<Object> deleteCliente(Long id) {

        HashMap<String, Object> dato;
        dato = new HashMap<>();
        boolean existe = this.clienteRepository.existsById(id);
        if (!existe) {
            dato.put("error", true);
            dato.put("mesagge", "No existe un cliente con ese id");
            return new ResponseEntity<>(
                    dato,
                    HttpStatus.CONFLICT);
        }
        clienteRepository.deleteById( id);
        dato.put("mesagge", "cliente eliminado");
        return new ResponseEntity<>(
                dato,
                HttpStatus.ACCEPTED);
    }


}