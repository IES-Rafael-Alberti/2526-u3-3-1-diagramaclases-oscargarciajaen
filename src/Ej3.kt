import java.time.localDate

class Cliente(val nombreCompleto: String, val direccionDeEnvio: String, val email: String, val numeroTelefono: Int){

}

class CuentaDePago(val numeroDeCuenta: Int, val saldoActual: Int){

    fun CobroPedido(){

    }
}

class TarjetaDeCredito(val nuemro: Int, val fechaDeVencimiento: localDate, val saldoDisponible: Int){

}

class Producto(val codigoUnico: Int, val nombre: String, val precioUnitario: Int, val stock: Int, val descripcion: String){

    fun verificarStock(){

    }
}

open class PedidoBase(val idPedido: Int, val estado: String){

    fun obtenerIMporteTotal(){

    }
}   

class pedidoSimple() : PedidoBase(idPedido, estado){

    fun verificarLimiteDeItems(){

    }
}

class PedidoCompuesto() : PedidoBase(idPedido, estado){

}

class LineaPedido(val cantidad: Int, val precioAplicado: Float){

}