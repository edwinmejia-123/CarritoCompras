class Carrito(val productos: MutableList<Producto> = mutableListOf()) {
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
}
