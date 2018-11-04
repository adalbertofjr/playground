package srpisp

import java.util.*

fun main(args: Array<String>) {

    val funcionario = Funcionario(0, "Dave Hal", Cargo.DESENVOLVEDOR, Calendar.getInstance(), 3500.00)

    val desconto = CalculadoraDeSalario().calcula(funcionario)

    println("O valor com desconto para o funcionário ${funcionario.nome} é de R$ $desconto")

}

// Classes coesas, com classes com responsabilidade única.
// Podemos pensar sobre coesão em vários níveis diferentes. Por exemplo, o que seria uma interface coesa? Uma interface
// coesa é aquela que também só possui uma única responsabilidade.
// E será que conseguimos ver a coesão pelo outro lado? Pense, se a classe A depende de B, idealmente B deve prover uma
// interface para A, somente com as coisas que A depende. Ou seja, a classe não deve depender de métodos que ela não usa.
// Isso é o que chamamos de Princípio de Segregação de Interfaces, ou ISP.