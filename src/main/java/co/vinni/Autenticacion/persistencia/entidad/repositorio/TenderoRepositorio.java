package co.vinni.Autenticacion.persistencia.entidad.repositorio;

import co.vinni.Autenticacion.persistencia.entidad.Tendero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderoRepositorio extends JpaRepository<Tendero, Long> {
}
