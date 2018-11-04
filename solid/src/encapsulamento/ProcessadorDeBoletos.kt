package encapsulamento


class ProcessadorDeBoletos {

    fun processa(boletos: List<Boleto>, fatura: Fatura) {

        var total = 0.0
        for (boleto in boletos) {
            val pagamento = Pagamento(boleto.valor, MeioDePagamento.BOLETO)
            fatura.adicionaPagamento(pagamento)
        }
    }
}