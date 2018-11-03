fun main(args: Array<String>) {
    val carros = getCarros()
    var maiorPreco = carros.get(0)

    maiorPreco = maisCaro(carros)

    println("${maiorPreco.name} é o carro mais caro e custa R$ ${maiorPreco.preco}")

}

private fun maisCaro(carros: List<Produto>): Produto {
    var maiorPreco = carros.get(0)
    carros.forEach { carro ->
        if (carro.preco > maiorPreco.preco) {
            maiorPreco = carro
        }
    }
    return maiorPreco
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