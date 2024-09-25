package co.vinni.Autenticacion.controlador;

import co.vinni.Autenticacion.persistencia.entidad.Tendero;
import co.vinni.Autenticacion.servicios.TenderoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenderos")
public class TenderoControlador {

    @Autowired
    private TenderoServicio tenderoServicio;

    // Ruta pública para el registro de tenderos
    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tendero> registrarTendero(@Validated @RequestBody Tendero tendero) {
        tenderoServicio.guardar(tendero);
        return new ResponseEntity<>(tendero, HttpStatus.CREATED);
    }

    // Ruta pública: lista todos los tenderos
    @GetMapping("/")
    public ResponseEntity<List<Tendero>> listarTenderos() {
        return ResponseEntity.ok(tenderoServicio.buscarTodos());
    }

    // Ruta pública: obtener tendero por ID
    @GetMapping("/{codigo}")
    public ResponseEntity<Tendero> obtenerPorId(@PathVariable("codigo") Long codigo) {
        Tendero tendero = tenderoServicio.buscarPorId(codigo);
        if (tendero == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(tendero);
    }
}
