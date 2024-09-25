package co.vinni.Autenticacion.persistencia.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "GRUPOS")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El nombre del grupo es obligatorio")
    @Column(unique = true)
    private String nombre;

    @NotBlank(message = "El código de invitación es obligatorio")
    private String codigoInvitacion;

    private String qrCode;  // Añadido para almacenar el código QR en base64

    // Relación muchos-a-uno con Tendero
    @ManyToOne
    @JoinColumn(name = "tendero_id", nullable = false)
    private Tendero tendero;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoInvitacion() {
        return codigoInvitacion;
    }

    public void setCodigoInvitacion(String codigoInvitacion) {
        this.codigoInvitacion = codigoInvitacion;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Tendero getTendero() {
        return tendero;
    }

    public void setTendero(Tendero tendero) {
        this.tendero = tendero;
    }
}
