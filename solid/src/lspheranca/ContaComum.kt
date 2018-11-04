package lspheranca

open class ContaComum() {
    private var manipulador: ManipuladorDeSaldo

    init {
        this.manipulador = ManipuladorDeSaldo()
    }

    open fun rende() {
        this.manipulador.rende(1.1)
    }

    open fun saca(valor: Double) {
        manipulador.saca(valor)
    }

    open fun deposita(valor: Double) {
        manipulador.deposita(valor)
    }

    open fun getSaldo() = manipulador.saldo
}
