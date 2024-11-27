package co.ucentral.diana.apibackendrondApp.controlador;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Tendero;
import co.ucentral.diana.apibackendrondApp.servicios.TenderoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenderos")
public class TenderoControlador {

    @Autowired
    private TenderoServicio tenderoServicio;

    @PostMapping("/registrar")
    public ResponseEntity<Tendero> registrarTendero(@RequestBody Tendero tendero) {
        return ResponseEntity.ok(tenderoServicio.registrarTendero(tendero));
    }

    @GetMapping("/{correo}")
    public ResponseEntity<Tendero> buscarPorCorreo(@PathVariable String correo) {
        return tenderoServicio.buscarPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
