package lspheranca

class ContaDeEstudante {
    private var manipulador: ManipuladorDeSaldo
    private var milhas: Int = 0

    init {
        this.manipulador = ManipuladorDeSaldo()
    }

    fun deposita(valor: Double) {
        this.manipulador.deposita(valor)
        this.milhas += valor as Int
    }

    fun getMilhas() = this.milhas
}
