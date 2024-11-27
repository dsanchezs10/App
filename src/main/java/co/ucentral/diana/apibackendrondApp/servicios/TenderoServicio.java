package co.ucentral.diana.apibackendrondApp.servicios;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Tendero;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio.TenderoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenderoServicio {

    @Autowired
    private TenderoRepositorio tenderoRepositorio;

    public Tendero registrarTendero(Tendero tendero) {
        return tenderoRepositorio.save(tendero);
    }

    public Optional<Tendero> buscarPorCorreo(String correo) {
        return tenderoRepositorio.findByCorreo(correo);
    }
}