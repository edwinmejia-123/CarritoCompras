import java.util.*
fun main() {
    val productos = listOf(
        Producto("Producto 1", 10.0, 5),
        Producto("Producto 2", 20.0, 3),
        Producto("Producto 3", 30.0, 1)
    )
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
            3 -> println("Funcion generar factura")
            4 -> {
                println("Gracias por usar la aplicación.")
                continuar = false
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}