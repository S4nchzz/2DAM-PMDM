package almacen

import almacen.bebidas.Agua
import almacen.bebidas.Bebida
import almacen.bebidas.CocaCola

fun main () {
    val almacen = Almacen();
    almacen.agregarBebida(Agua(1, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(2, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(3, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(4, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(5, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(6, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(7, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(8, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(9, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(10, 1.5f, 1.0, "MarcaA", "Manantial"));
    almacen.agregarBebida(Agua(11, 1.5f, 1.0, "MarcaA", "Manantial"));
    print(almacen.calcularPrecio(0));
}

class Almacen {
    private val matrix: MutableList<MutableList<Bebida>>;

    constructor() {
        this.matrix = mutableListOf();

        for (i in 0..4) {
            var row: MutableList<Bebida> = mutableListOf();
            matrix.add(matrix.size, row)
        }
    }

    fun agregarBebida(bebida: Bebida) {
        matrix.forEach{col ->
            col.forEach{row ->
                if (row.id == bebida.id) {
                    return;
                }
            }
        }

        for (col in matrix) {
            if (col.size < 5) {
                col.add(bebida)
                return
            }
        }
    }

    fun eliminarBebida(id: Int) {
        matrix.forEach { col ->
            col.removeIf { it.id == id}
        }
    }

    fun mostrarBebida(id: Int) {
        matrix.forEach { col ->
            col.forEach { element ->
                if (element.id == id) {
                    println(element)
                }
            }
        }
    }

    fun mostrarBebida() {
        matrix.forEach { col ->
            for (element in col) {
                println(element.toString());
            }
        }
    }

    fun calcularPrecio() : Double {
        var value: Double = 0.0;

        for (row in matrix) {
            for (element in row) {
                if (element is CocaCola) {
                    val descuento: Double = element.precio * 0.1;
                    value += element.precio - descuento;
                } else {
                    value += element.precio;
                }
            }
        }

        return value;
    }

    fun calcularPrecio(marca: String) : Double {
        var value: Double = 0.0;

        for (row in matrix) {
            for (element in row) {
                if (element is CocaCola && element.marca == marca) {
                    val descuento: Double = element.precio * 0.1;
                    value += element.precio - descuento;
                } else if (element.marca == marca) {
                    value += element.precio;
                }
            }
        }

        return value;
    }

    fun calcularPrecio(colProvided: Int) : Double {
        var value: Double = 0.0;

        for (row in matrix) {
            var col: Int = 0;
            for (element in row) {
               if (col == colProvided) {
                   if (element is CocaCola) {
                       val descuento: Double = element.precio * 0.1;
                       value += element.precio - descuento;
                   } else {
                       value += element.precio;
                   }
               }
                col++;
            }
        }

        return value;
    }
}