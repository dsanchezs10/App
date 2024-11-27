package co.ucentral.diana.apibackendrondApp.servicios;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Grupo;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Tendero;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoServicio {

    @Autowired
    private GrupoRepositorio grupoRepositorio;

    public Grupo crearGrupo(Grupo grupo) {
        return grupoRepositorio.save(grupo);
    }

    public Optional<Grupo> buscarPorCodigo(String codigo) {
        return grupoRepositorio.findByCodigo(codigo);
    }

    public void eliminarGrupo(Long id) {
        grupoRepositorio.deleteById(id);
    }

    public List<Grupo> listarGrupos() {
        return grupoRepositorio.findAll();
    }
}