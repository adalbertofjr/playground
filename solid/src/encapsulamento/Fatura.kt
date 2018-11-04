package encapsulamento

class Fatura(val cliente: String? = null, val valor: Double = 0.toDouble(), var pagamentos: MutableList<Pagamento>, private var pago: Boolean = false) {



    fun setPago(pago: Boolean) {
        this.pago = pago
    }

    fun adicionaPagamento(pagamento: Pagamento) {
        this.pagamentos.add(pagamento)

        if (valorTotalDosPagamentos() > this.valor) {
            setPago(true)
        }
    }

    private fun valorTotalDosPagamentos(): Double {
        var total = 0.0

        for (p in pagamentos) {
            total += p.valor
        }
        return total
    }
}