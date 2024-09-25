package co.vinni.Autenticacion.servicios;

import co.vinni.Autenticacion.persistencia.entidad.Grupo;
import co.vinni.Autenticacion.persistencia.entidad.repositorio.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServicio {

    @Autowired
    private GrupoRepositorio grupoRepositorio;

    public Grupo crearGrupo(Grupo grupo) {
        return grupoRepositorio.save(grupo);
    }

    public List<Grupo> obtenerGruposPorTendero(Long tenderoCodigo) {
        return grupoRepositorio.findByTendero_Codigo(tenderoCodigo);
    }
}
