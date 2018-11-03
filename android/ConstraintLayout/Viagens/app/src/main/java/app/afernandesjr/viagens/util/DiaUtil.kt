package app.afernandesjr.viagens.util

class DiaUtil {
    companion object {
        private val SINGULAR = "dia"
        private val PLURAL = "dias"

        fun formatarDia(dias: Int): String {
            if (dias > 1) {
                return "${dias} $PLURAL"
            }

            return "${dias} $SINGULAR"
        }
    }
}