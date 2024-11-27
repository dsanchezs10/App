package co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Cliente;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNombreAndGrupoCodigo(String nombre, String codigoGrupo);
    List<Cliente> findByGrupoId(Long grupoId);
}