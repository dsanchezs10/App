package co.vinni.Autenticacion.controlador;

import co.vinni.Autenticacion.servicios.QRServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qr")
public class QRControlador {

    private final QRServicio qrServicio;

    @Autowired
    public QRControlador(QRServicio qrServicio) {
        this.qrServicio = qrServicio;
    }

    @GetMapping("/generar")
    public ResponseEntity<String> generarQRCodeBase64(@RequestParam("texto") String texto) {
        try {
            String qrCodeBase64 = qrServicio.generarQRCodeBase64(texto, 250, 250);
            return new ResponseEntity<>(qrCodeBase64, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error generando el código QR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
