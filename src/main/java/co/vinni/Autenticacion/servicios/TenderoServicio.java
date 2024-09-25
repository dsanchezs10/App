package co.vinni.Autenticacion.servicios;

import co.vinni.Autenticacion.persistencia.entidad.Tendero;
import co.vinni.Autenticacion.persistencia.entidad.repositorio.TenderoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenderoServicio {

    @Autowired
    private TenderoRepositorio tenderoRepositorio;

    public Tendero buscarPorId(Long id) {
        return tenderoRepositorio.findById(id).orElse(null);
    }

    public List<Tendero> buscarTodos() {
        return tenderoRepositorio.findAll();
    }

    public void guardar(Tendero tendero) {
        tenderoRepositorio.save(tendero);
    }
}
