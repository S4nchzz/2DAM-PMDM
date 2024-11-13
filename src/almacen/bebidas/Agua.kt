package almacen.bebidas

class Agua(id: Int, litros: Float, precio: Double, marca: String, val origen: String) : Bebida(id, litros, precio, marca) {
    override fun toString(): String {
        return "ID: $id, Litros: $litros, Precio: $precio, Marca: $marca, Origen: $origen"
    }
}