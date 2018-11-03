package acoplamento


fun main(args: Array<String>) {

    val geradorDeNotaFiscal = GeradorDeNotaFiscal(listOf(EnviadorDeEmail(), NotaFiscalDao()))
    val fatura = Fatura(300.toDouble(), "HAL Soluções")

    geradorDeNotaFiscal.gera(fatura)
}

// São as dependências, classes com baixo acoplamento são legais e a utilização de abstração ajuda a diminuir o acoplamento.