package ocpdip

class TabelaDePrecoPadrao : TabelaDePreco {

    override fun descontoPara(valor: Double): Double {
        if (valor > 5000) return 0.03
        return if (valor > 1000) 0.05 else 0.0
    }
}
