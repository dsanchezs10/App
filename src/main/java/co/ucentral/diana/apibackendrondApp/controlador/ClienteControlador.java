package co.ucentral.diana.apibackendrondApp.controlador;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Cliente;
import co.ucentral.diana.apibackendrondApp.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/registrar")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteServicio.registrarCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> buscarPorNombreYCodigoGrupo(@RequestParam String nombre, @RequestParam String codigoGrupo) {
        Cliente cliente = clienteServicio.buscarPorNombreYCodigoGrupo(nombre, codigoGrupo);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/grupo/{grupoId}")
    public ResponseEntity<List<Cliente>> listarClientesPorGrupo(@PathVariable Long grupoId) {
        return ResponseEntity.ok(clienteServicio.listarClientesPorGrupo(grupoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}