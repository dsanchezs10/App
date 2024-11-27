package co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Tendero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenderoRepositorio extends JpaRepository<Tendero, Long> {
    Optional<Tendero> findByCorreo(String correo);
}