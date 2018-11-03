package acoplamento

class GeradorDeNotaFiscal(val acoes: List<AcaoAposGerarNota>) {

    fun gera(fatura: Fatura): NotaFiscal {

        val valor = fatura.valorMensal

        val nf = NotaFiscal(valor, impostoSimplesSobreO(valor))

        acoes.forEach { acao ->
            acao.executa(nf)
        }

        return nf
    }

    private fun impostoSimplesSobreO(valor: Double): Double {
        return valor * 0.06
    }
}