package srp

import java.util.*

fun main(args: Array<String>) {

    val funcionario = Funcionario(0, "Dave Hal", Cargo.DESENVOLVEDOR, Calendar.getInstance(), 3500.00)

    val desconto = CalculadoraDeSalario().calcula(funcionario)

    println("O valor com desconto para o funcionário ${funcionario.nome} é de R$ $desconto")

}

// Classes coesas, com responsabilidade única.