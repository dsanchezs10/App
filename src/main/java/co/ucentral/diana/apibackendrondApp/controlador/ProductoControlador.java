package co.ucentral.diana.apibackendrondApp.controlador;

import co.ucentral.diana.apibackendrondApp.persistencia.entidad.Producto;
import co.ucentral.diana.apibackendrondApp.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoServicio.crearProducto(producto));
    }

    @GetMapping("/grupo/{grupoId}")
    public ResponseEntity<List<Producto>> listarProductosPorGrupo(@PathVariable Long grupoId) {
        return ResponseEntity.ok(productoServicio.listarProductosPorGrupo(grupoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return ResponseEntity.ok(productoServicio.actualizarProducto(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoServicio.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}