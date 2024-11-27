package co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByClienteGrupoId(Long grupoId);
}