class Carrito(val productos: MutableList<Producto> = mutableListOf()) {
    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (cantidad <= 0) {
            println("La cantidad debe ser mayor a 0.")
            return
        }
        if (producto.cantidadDisponible < cantidad) {
            println("No hay suficiente cantidad disponible del producto ${producto.nombre}.")
            return
        }
        val indiceProducto = productos.indexOfFirst { it.nombre == producto.nombre }
        if (indiceProducto == -1) {
            productos.add(producto.copy(cantidadDisponible = cantidad))
        } else {
            productos[indiceProducto] = productos[indiceProducto].copy(cantidadDisponible = productos[indiceProducto].cantidadDisponible + cantidad)
        }
        println("Producto ${producto.nombre} agregado al carrito.")
    }

    fun eliminarProducto(nombreProducto: String) {
        val indiceProducto = productos.indexOfFirst { it.nombre == nombreProducto }
        if (indiceProducto == -1) {
            println("No se encontró el producto $nombreProducto en el carrito.")
            return
        }
        productos.removeAt(indiceProducto)
        println("Producto $nombreProducto eliminado del carrito.")
    }

    fun mostrarCarrito() {
        if (productos.isEmpty()) {
            println("El carrito está vacío.")
            return
        }
        println("Productos en el carrito:")
        var totalGeneral = 0.0
        productos.forEach { producto ->
            val precioTotal = producto.precio * producto.cantidadDisponible
            totalGeneral += precioTotal
            println("${producto.nombre}, Cantidad: ${producto.cantidadDisponible}, Precio unitario: ${producto.precio}, Precio total: $precioTotal")
        }
        println("Total general del carrito: $totalGeneral")
    }

    fun generarFactura(): String {
        if (productos.isEmpty()) {
            return "El carrito está vacío."
        }
        var factura = "Factura:\n"
        var totalGeneral = 0.0
        productos.forEach { producto ->
            val precioTotal = producto.precio * producto.cantidadDisponible
            totalGeneral += precioTotal
            factura += "Producto: ${producto.nombre}, Cantidad: ${producto.cantidadDisponible}, Precio unitario: ${producto.precio}, Precio total: $precioTotal\n"
        }
        factura += "Total general de la compra: $totalGeneral"
        return factura
    }
}
