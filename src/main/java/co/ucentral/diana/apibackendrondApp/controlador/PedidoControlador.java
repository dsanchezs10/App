package co.ucentral.diana.apibackendrondApp.controlador;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Pedido;
import co.ucentral.diana.apibackendrondApp.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @PostMapping("/realizar")
    public ResponseEntity<Pedido> realizarPedido(@RequestBody Pedido pedido) {
        // Validaciones de cantidad y precio del producto
        if (pedido.getProducto() == null || pedido.getProducto().getPrecio() == null) {
            throw new IllegalArgumentException("El precio del producto es obligatorio para calcular el total.");
        }
        if (pedido.getCantidad() == null || pedido.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        pedido.setTotal(pedido.getCantidad() * pedido.getProducto().getPrecio());
        return ResponseEntity.ok(pedidoServicio.realizarPedido(pedido));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> listarPedidosPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(pedidoServicio.listarPedidosPorCliente(clienteId));
    }

    @GetMapping("/grupo/{grupoId}")
    public ResponseEntity<List<Pedido>> listarPedidosPorGrupo(@PathVariable Long grupoId) {
        return ResponseEntity.ok(pedidoServicio.listarPedidosPorGrupo(grupoId));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstadoPedido(@PathVariable Long id, @RequestParam String estado) {
        Pedido.EstadoPedido estadoPedido;
        try {
            estadoPedido = Pedido.EstadoPedido.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado inválido: " + estado);
        }
        return ResponseEntity.ok(pedidoServicio.actualizarEstadoPedido(id, estadoPedido));
    }
}
