package app.afernandesjr.viagens.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class MoedaUtil {

    companion object {
        private val PORTUGUES = "pt"
        private val BRASIL = "br"
        private val FORMATO_PADRAO = "R$"
        private val FORMATO_COM_ESPACO = "R$ "

        fun formatarPreco(preco: BigDecimal): String {
            var formatoMoedaBrasileiro = DecimalFormat.getCurrencyInstance(Locale(PORTUGUES, BRASIL))
            var precoFormatado = formatoMoedaBrasileiro.format(preco).replace(FORMATO_PADRAO, FORMATO_COM_ESPACO)
            return precoFormatado
        }
    }
}