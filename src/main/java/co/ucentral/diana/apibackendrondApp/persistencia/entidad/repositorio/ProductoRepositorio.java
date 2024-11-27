package co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Grupo;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    List<Producto> findByGrupoId(Long grupoId);
}
