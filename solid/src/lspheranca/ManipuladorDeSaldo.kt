package lspheranca

class ManipuladorDeSaldo {
    var saldo: Double = 0.toDouble()

    fun deposita(valor: Double) {
        this.saldo += valor
    }

    fun saca(valor: Double) {
        if (valor <= this.saldo) {
            this.saldo -= valor
        } else {
            throw IllegalArgumentException()
        }
    }

    fun rende(taxa: Double) {
        this.saldo *= taxa
    }
}