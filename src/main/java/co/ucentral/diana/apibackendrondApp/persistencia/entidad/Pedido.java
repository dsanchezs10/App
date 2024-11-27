package co.ucentral.diana.apibackendrondApp.persistencia.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @NotNull(message = "La cantidad es obligatoria.")
    private Integer cantidad;

    @NotNull(message = "El precio total es obligatorio.")
    private Double total;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.SOLICITADO;

    public enum EstadoPedido {
        SOLICITADO,
        PENDIENTE,
        CANCELADO,
        ENTREGADO
    }
}
