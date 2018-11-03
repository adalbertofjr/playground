package acoplamento

class NotaFiscalDao : AcaoAposGerarNota {

    override fun executa(notaFiscal: NotaFiscal) {
        println("salva nf no banco")
    }
}