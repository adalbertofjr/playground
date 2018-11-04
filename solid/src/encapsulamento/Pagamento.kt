package encapsulamento

class Pagamento(val valor: Double, val forma: MeioDePagamento) {


    override fun equals(obj: Any?): Boolean {
        if (obj !is Pagamento) {
            return false
        }

        val outro = obj as Pagamento?
        return if (forma !== outro!!.forma || java.lang.Double.doubleToLongBits(valor) != java.lang.Double
                        .doubleToLongBits(outro!!.valor)) {
            false
        } else {
            true
        }

    }

}
