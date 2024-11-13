package almacen.bebidas

class CocaCola(id: Int, litros: Float, precio: Double, marca: String, val azucar: Float, val descuento: Boolean) : Bebida(id, litros, precio, marca){
    override fun toString(): String {
        return "ID: $id, Litros: $litros, Precio: $precio, Marca: $marca, Azucar: $azucar, Descuento: $descuento"
    }
}