package almacen.bebidas

abstract class Bebida(val id: Int, val litros: Float, val precio: Double, val marca: String) {
    override fun toString(): String {
        return "ID: $id, Litros: $litros, Precio: $precio, Marca: $marca"
    }
}