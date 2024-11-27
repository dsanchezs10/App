package co.ucentral.diana.apibackendrondApp.servicios;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Cliente;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Grupo;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente registrarCliente(Cliente cliente) {
        if (cliente.getGrupo() == null || cliente.getGrupo().getCodigo() == null || cliente.getGrupo().getCodigo().isEmpty()) {
            throw new IllegalArgumentException("El código de grupo es obligatorio.");
        }
        return clienteRepositorio.save(cliente);
    }

    public Cliente buscarPorNombreYCodigoGrupo(String nombre, String codigoGrupo) {
        return clienteRepositorio.findByNombreAndGrupoCodigo(nombre, codigoGrupo);
    }

    public List<Cliente> listarClientesPorGrupo(Long grupoId) {
        return clienteRepositorio.findByGrupoId(grupoId);
    }

    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }
}