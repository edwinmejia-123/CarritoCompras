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
            1 -> println("Mostrar productos Funcion")
            2 -> println("Funcion mostrar carrito")
            3 -> println(carrito.generarFactura())
            4 -> {
                println("Gracias por usar la aplicación.")
                continuar = false
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}

fun mostrarProductos(productos: List<Producto>, scanner: Scanner) {
    var regresar = false
    while (!regresar) {
        println("\nProductos disponibles:")

        println("\n****************************************")
        println("**** 1. Agregar producto al carrito ****")
        println("**** 2. Regresar al menú principal  ****")
        println("**** 3. Salir                       ****")
        println("***************************************")
        print("Seleccione una opción: ")
        when (scanner.nextInt()) {
            1 -> println("Funcion agregar producto al carrito")
            2 -> regresar = true
            3 -> {
                println("Gracias por usar la aplicación.")
                System.exit(0)
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}

fun mostrarCarrito( scanner: Scanner) {
    var regresar = false
    while (!regresar) {
        println("\nProductos seleccionados:")
        //Mostrar la lista de productos del carrito
        println("\n***************************************")
        println("****1. Editar cantidad de producto ****")
        println("****2. Eliminar producto             ****")
        println("****3. Regresar al menú principal    ****")
        println("****4. Salir                         ****")
        println("***************************************")
        print("Seleccione una opción: ")
        when (scanner.nextInt()) {
            1 -> println("Editar cantidad de producto")
            2 -> println("Eliminar producto")
            3 -> regresar = true
            4 -> {
                println("Gracias por usar la aplicación.")
                System.exit(0)
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}