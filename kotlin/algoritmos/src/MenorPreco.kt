fun main(args: Array<String>) {
    val carros = getCarros()
    var maisBarato = carros.get(0)

    maisBarato = maisBarato(carros, 0, carros.size)

    println("${maisBarato.name} é o carro mais barato e custa R$ ${maisBarato.preco}")

}

private fun maisBarato(carros: List<Produto>): Produto {
    var maisBarato = carros.get(0)

    for (carro in carros) {
        if (carro.preco < maisBarato.preco) {
            maisBarato = carro
        }
    }

    return maisBarato
}

private fun maisBarato(carros: List<Produto>, inicio: Int, fim: Int): Produto {
    var maisBarato = carros.get(inicio)

    for (i: Int in inicio until fim) {
        if (carros.get(i).preco < maisBarato.preco) {
            maisBarato = carros.get(i)
        }
    }

    return maisBarato
}


data class Produto(val name: String, val preco: Double)


fun getCarros(): List<Produto> {

    return listOf(
            Produto("Lamborghini", 1000000.0),
            Produto("Jipe", 46000.0),
            Produto("Brasília", 16000.0),
            Produto("Smart", 46000.00),
            Produto("Fusca", 17000.0)
    )
}

//Algoritmo
//maisBarato=0
//atual = 0
//
//para atual = 0 até inclusive {
//    se precos[atual] < precos[maisBarato] {
//        maisBarato = atual
//    }
//}