package acoplamento

class NotaFiscal(var id: Int = 0, var valorBruto: Double = 0.toDouble(), var impostos: Double = 0.toDouble()) {

    constructor(valorBruto: Double, impostos: Double) : this(0, valorBruto, impostos)

    fun getValorLiquido(): Double {
        return this.valorBruto - this.impostos
    }
}
