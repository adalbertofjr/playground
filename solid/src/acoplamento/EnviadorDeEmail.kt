package acoplamento

class EnviadorDeEmail : AcaoAposGerarNota {

    override fun executa(notaFiscal: NotaFiscal) {
        System.out.println("envia email da nf " + notaFiscal.id)
    }
}
