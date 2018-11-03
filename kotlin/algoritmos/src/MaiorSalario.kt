fun main(args: Array<String>) {

    val funcionarios = getFuncionarios()

    var menorSalario = funcionarios.get(0)
    var maiorSalario = funcionarios.get(0)

    funcionarios.forEach { funcionario ->
        if (funcionario.salario < menorSalario.salario) {
            menorSalario = funcionario
        }

        if (funcionario.salario > maiorSalario.salario) {
            maiorSalario = funcionario
        }
    }

    println("${menorSalario.name} possui o menor salário: R$ ${menorSalario.salario}")
    println("${maiorSalario.name} possui o maior salário: R$ ${maiorSalario.salario}")

}

data class Funcionario(val name: String, val salario: Double)

fun getFuncionarios(): List<Funcionario> {
    return listOf(
            Funcionario("Fernando", 3200.0),
            Funcionario("Alfredo", 6000.0),
            Funcionario("Flávio", 5000.0),
            Funcionario("Marcela", 2200.0)
    )
}

//0 - Fernando R$ 3.200,00
//1 - Alfredo R$ 6.000,00
//2- Flávio R$ 5.000,00
//3 - Marcela R$ 2.200,00