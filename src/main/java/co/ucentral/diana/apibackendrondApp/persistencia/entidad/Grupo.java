package co.ucentral.diana.apibackendrondApp.persistencia.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "grupos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del grupo es obligatorio.")
    private String nombre;

    @NotBlank(message = "El código del grupo es obligatorio.")
    @Column(unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "tendero_id", nullable = false)
    private Tendero tendero;
}