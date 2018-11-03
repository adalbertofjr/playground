package ocpdip

class CalculadoraDePrecos(val tabela: TabelaDePreco, val envia: ServicoEntrega) {

    fun calcula(produto: Compra): Double {
        val desconto = tabela.descontoPara(produto.valor)
        val frete = envia.para(produto.cidade)

        return produto.valor * (1 - desconto) + frete
    }
}