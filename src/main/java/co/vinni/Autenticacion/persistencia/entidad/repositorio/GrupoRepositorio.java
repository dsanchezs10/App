package co.vinni.Autenticacion.persistencia.entidad.repositorio;

import co.vinni.Autenticacion.persistencia.entidad.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo, Long> {
    // Cambio aquí para buscar por tendero.codigo
    List<Grupo> findByTendero_Codigo(Long codigo);
}
