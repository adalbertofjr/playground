package ocpdip

class Frete : ServicoEntrega {

    override fun para(cidade: String): Double {
        if ("SAO PAULO" == cidade.toUpperCase()) {
            return 15.0
        }

        return 30.0
    }
}
