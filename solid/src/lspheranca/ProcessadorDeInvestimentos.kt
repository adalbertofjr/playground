package lspheranca

import java.util.Arrays


fun main(args: Array<String>) {

    for (conta in contasDoBanco()) {
        conta.rende()

        println("Novo Saldo:")
        System.out.println(conta.getSaldo())
    }
}


private fun contasDoBanco(): List<ContaComum> {
    return Arrays.asList<ContaComum>(umaContaCom(100.0), umaContaCom(150.0))
}

private fun contaDeEstudanteCom(amount: Double): ContaDeEstudante {
    val c = ContaDeEstudante()
    c.deposita(amount)
    return c
}

private fun umaContaCom(valor: Double): ContaComum {
    val c = ContaComum()
    c.deposita(valor)
    return c
}