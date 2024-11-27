package co.ucentral.diana.apibackendrondApp.servicios;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Pedido;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public Pedido realizarPedido(Pedido pedido) {
        // Aquí podrías agregar lógica adicional para validar datos antes de guardar
        return pedidoRepositorio.save(pedido);
    }

    public List<Pedido> listarPedidosPorCliente(Long clienteId) {
        return pedidoRepositorio.findByClienteId(clienteId);
    }

    public List<Pedido> listarPedidosPorGrupo(Long grupoId) {
        return pedidoRepositorio.findByClienteGrupoId(grupoId);
    }

    public Pedido actualizarEstadoPedido(Long id, Pedido.EstadoPedido estado) {
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(estado);
        return pedidoRepositorio.save(pedido);
    }
}
