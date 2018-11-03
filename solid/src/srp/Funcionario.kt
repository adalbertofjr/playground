package srp

import java.util.*

class Funcionario(val id: Int, var nome: String, var cargo: Cargo, var dataDeAdmissao: Calendar?, var salarioBase: Double) {

    fun calculaSalario(): Double {
        return cargo.regra.calcula(this)
    }
}


