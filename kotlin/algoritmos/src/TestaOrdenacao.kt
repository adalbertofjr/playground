fun main(args: Array<String>) {

    val produtos = arrayOf(
            Produto("Lamborghini", 1000000.0),
            Produto("Jipe", 46000.0),
            Produto("Brasília", 16000.0),
            Produto("Smart", 46000.0),
            Produto("Fusca", 17000.0))


//    selectionSort(produtos, produtos.size)
    insertionSort(produtos, produtos.size)

    print(produtos.toList())

}

fun insertionSort(produtos: Array<Produto>, quantidadeElementos: Int) {
    for (i: Int in 0 until quantidadeElementos) {
        var analise = i
        while (analise > 0 && produtos[analise].preco < produtos[analise - 1].preco) {
            val produtoAnalise = produtos[analise]
            val produtoAnaliseMenosUm = produtos[analise - 1]

            produtos[analise] = produtoAnaliseMenosUm
            produtos[analise - 1] = produtoAnalise
            analise--
        }
    }
}

private fun selectionSort(produtos: Array<Produto>, quantidadeElementos: Int) {
    for (i: Int in 0 until quantidadeElementos) {
        val menor = buscaMenorPreco(produtos, i, quantidadeElementos)
        val produtoMenor = produtos[menor]
        val produtoAtual = produtos[i]

        produtos[i] = produtoMenor
        produtos[menor] = produtoAtual

    }
}

private fun buscaMenorPreco(produtos: Array<Produto>, inicio: Int, fim: Int): Int {
    var maisBarato = inicio
    for (i: Int in inicio until fim) {
        if (produtos.get(i).preco < produtos.get(maisBarato).preco) {
            maisBarato = i
        }
    }

    return maisBarato
}