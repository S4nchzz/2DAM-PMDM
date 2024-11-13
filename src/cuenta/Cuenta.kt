package cuenta

fun main () {
    val c = Cuenta("AAA");
    c.ingresar(100.0)
    c.retirar(70.0);
    print(c);
}

class Cuenta constructor(titulo: String){
    var salario: Double = 0.0;

    constructor(titulo: String, salario: Double) : this(titulo) {
        if (salario < 0) {
            this.salario = 0.0;
        }
    }
    
    fun ingresar(ingresar: Double) {
        if (ingresar <= 0) {
            return;
        }

        salario += ingresar;
    }
    
    fun retirar(retirar: Double) {
        this.salario -= retirar;

        if (salario < 0) {
            salario = 0.0;
        }
    }

    override fun toString(): String {
        return salario.toString();
    }
}