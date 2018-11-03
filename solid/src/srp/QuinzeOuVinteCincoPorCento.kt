package srp

class QuinzeOuVinteCincoPorCento : RegraDeCalculo {

    override fun calcula(funcionario: Funcionario): Double {
        if (funcionario.salarioBase > 2000.0) {
            return funcionario.salarioBase * 0.75
        }

        return funcionario.salarioBase * 0.85
    }
}