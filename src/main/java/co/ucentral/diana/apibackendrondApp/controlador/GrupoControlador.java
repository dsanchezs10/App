package co.ucentral.diana.apibackendrondApp.controlador;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Grupo;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Tendero;
import co.ucentral.diana.apibackendrondApp.servicios.GrupoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grupos")
public class GrupoControlador {

    @Autowired
    private GrupoServicio grupoServicio;

    @PostMapping("/crear")
    public ResponseEntity<Grupo> crearGrupo(@RequestBody Grupo grupo) {
        return ResponseEntity.ok(grupoServicio.crearGrupo(grupo));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Grupo> buscarPorCodigo(@PathVariable String codigo) {
        return grupoServicio.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrupo(@PathVariable Long id) {
        grupoServicio.eliminarGrupo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> listarGrupos() {
        return ResponseEntity.ok(grupoServicio.listarGrupos());
    }
}
