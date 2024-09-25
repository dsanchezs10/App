package co.vinni.Autenticacion.controlador;

import co.vinni.Autenticacion.persistencia.entidad.Grupo;
import co.vinni.Autenticacion.servicios.GrupoServicio;
import co.vinni.Autenticacion.servicios.TenderoServicio;
import co.vinni.Autenticacion.servicios.QRServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/grupos")
public class GrupoControlador {

    @Autowired
    private GrupoServicio grupoServicio;

    @Autowired
    private TenderoServicio tenderoServicio;

    @Autowired
    private QRServicio qrServicio;

    // Crear un grupo por parte de un tendero
    @PostMapping("/crear")
    public ResponseEntity<Grupo> crearGrupo(@Validated @RequestBody Grupo grupo, @RequestParam("tenderoId") Long tenderoId) {
        // Asignar el tendero que creó el grupo
        grupo.setTendero(tenderoServicio.buscarPorId(tenderoId));
        if (grupo.getTendero() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Generar código de invitación
        grupo.setCodigoInvitacion(UUID.randomUUID().toString());

        // Generar código QR para el código de invitación en base64
        try {
            String qrCodeBase64 = qrServicio.generarQRCodeBase64(grupo.getCodigoInvitacion(), 250, 250);
            grupo.setQrCode(qrCodeBase64);  // Almacenar el código QR en la entidad
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        Grupo grupoCreado = grupoServicio.crearGrupo(grupo);
        return new ResponseEntity<>(grupoCreado, HttpStatus.CREATED);
    }

    // Obtener todos los grupos creados por un tendero
    @GetMapping("/tendero/{tenderoCodigo}")
    public ResponseEntity<List<Grupo>> obtenerGruposPorTendero(@PathVariable("tenderoCodigo") Long tenderoCodigo) {
        List<Grupo> grupos = grupoServicio.obtenerGruposPorTendero(tenderoCodigo);
        if (grupos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(grupos);
    }
}
