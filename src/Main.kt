import java.util.*
fun main() {
    val productos = listOf(
        Producto("Producto 1", 10.0, 5),
        Producto("Producto 2", 20.0, 3),
        Producto("Producto 3", 30.0, 1)
    )
    val carrito = Carrito()
    val scanner = Scanner(System.`in`)
    var continuar = true
    while (continuar) {
        println("\nOpciones principales:")
        println("1. Mostrar productos")
        println("2. Mostrar carrito")
        println("3. Generar factura")
        println("4. Salir")
        print("Seleccione una opción: ")
        when (scanner.nextInt()) {
            1 -> mostrarProductos(productos, carrito, scanner)
            2 -> mostrarCarrito(carrito, scanner)
            3 -> println(carrito.generarFactura())
            4 -> {
                println("Gracias por usar la aplicación.")
                continuar = false
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}

fun mostrarProductos(productos: List<Producto>, carrito: Carrito, scanner: Scanner) {
    var regresar = false
    while (!regresar) {
        println("\nProductos disponibles:")
        listarProducto(productos)
        print("Ingrese el número del producto: ")
        println("\n****************************************")
        println("**** 1. Agregar producto al carrito ****")
        println("**** 2. Regresar al menú principal  ****")
        println("**** 3. Salir                       ****")
        println("***************************************")
        print("Seleccione una opción: ")
        when (scanner.nextInt()) {
            1 -> {
                listarProducto(productos)
                print("Ingrese el número del producto: ")
                val numProducto = scanner.nextInt()
                if (numProducto in 1..productos.size) {
                    val producto = productos[numProducto - 1]
                    print("Ingrese la cantidad a comprar: ")
                    var cantidad = scanner.nextInt()
                    while (cantidad > producto.cantidadDisponible) {
                        println("No hay suficiente stock para el producto ${producto.nombre}. Cantidad disponible: ${producto.cantidadDisponible}. Ingrese una cantidad válida: ")
                        cantidad = scanner.nextInt()
                    }
                    carrito.agregarProducto(producto.copy(), cantidad)
                    producto.cantidadDisponible -= cantidad // Disminuir la cantidad disponible del producto
                } else {
                    println("Número de producto no válido.")
                }
            }
            2 -> regresar = true
            3 -> {
                println("Gracias por usar la aplicación.")
                System.exit(0)
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}

fun mostrarCarrito( carrito: Carrito, scanner: Scanner) {
    var regresar = false
    while (!regresar) {
        println("\nProductos seleccionados:")
        carrito.mostrarCarrito()
        println("\n***************************************")
        println("****1. Editar cantidad de producto ****")
        println("****2. Eliminar producto             ****")
        println("****3. Regresar al menú principal    ****")
        println("****4. Salir                         ****")
        println("***************************************")
        print("Seleccione una opción: ")
        when (scanner.nextInt()) {
            1 -> {
                carrito.mostrarCarrito()
                println("Ingrese el número del producto para editar:")

                val numProducto = scanner.nextInt()
                if (numProducto in 1..carrito.productos.size) {
                    val producto = carrito.productos[numProducto - 1]
                    print("Ingrese la nueva cantidad para \"${producto.nombre}\": ")
                    val cantidad = scanner.nextInt()
                    if (cantidad > 0) {
                        carrito.eliminarProducto(producto.nombre)
                        carrito.agregarProducto(producto, cantidad)
                    } else if (cantidad <= 0) {
                        carrito.eliminarProducto(producto.nombre)
                        println("Producto eliminado del carrito.")
                    }
                } else {
                    println("Número de producto no válido.")
                }
            }
            2 -> {
                println("Ingrese el número del producto para eliminar:")
                carrito.mostrarCarrito()
                val numProducto = scanner.nextInt()
                if (numProducto in 1..carrito.productos.size) {
                    val producto = carrito.productos[numProducto - 1]
                    carrito.eliminarProducto(producto.nombre)

                    println("Producto \"${producto.nombre}\" eliminado del carrito.")
                } else {
                    println("Número de producto no válido.")
                }
            }
            3 -> regresar = true
            4 -> {
                println("Gracias por usar la aplicación.")
                System.exit(0)
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}

fun listarProducto(productos: List<Producto>){
    productos.forEachIndexed { index, producto ->
        println("${index + 1}. \"${producto.nombre}\", ${producto.precio}, ${producto.cantidadDisponible}")
    }
}