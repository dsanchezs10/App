package co.ucentral.diana.apibackendrondApp.persistencia.entidad;

public enum EstadoPedido {
    SOLICITADO,  // Cuando el pedido ha sido creado por el cliente
    PENDIENTE,   // Cuando el tendero lo está procesando
    CANCELADO,   // Cuando el pedido ha sido cancelado
    ENTREGADO    // Cuando el pedido ha sido entregado exitosamente
}
