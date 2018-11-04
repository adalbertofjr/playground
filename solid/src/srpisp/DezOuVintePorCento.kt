package srpisp

class DezOuVintePorCento : RegraDeCalculo {

    override fun calcula(funcionario: Funcionario): Double {
        if (funcionario.salarioBase > 3000.0) {
            return funcionario.salarioBase * 0.8
        }

        return funcionario.salarioBase * 0.9
    }
}