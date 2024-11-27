package co.ucentral.diana.apibackendrondApp.servicios;



import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Grupo;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Producto;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio.GrupoRepositorio;
import co.ucentral.diana.apibackendrondApp.persistencia.entidad.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public List<Producto> listarProductosPorGrupo(Long grupoId) {
        return productoRepositorio.findByGrupoId(grupoId);
    }

    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }

    public Producto actualizarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }
}