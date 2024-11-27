package co.ucentral.diana.apibackendrondApp.persistencia.entidad;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tenderos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tendero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre  es obligatorio.")
    private String nombre;

    @NotBlank(message = "El nombre del negocio es obligatorio.")
    private String nombreNegocio;

    @NotBlank(message = "La dirección es obligatoria.")
    private String direccion;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "Debe ser un correo válido.")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private String contrasena;
}
