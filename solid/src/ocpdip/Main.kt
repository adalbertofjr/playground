package ocpdip

fun main(args: Array<String>) {

    val calculadoraDePrecos = CalculadoraDePrecos(TabelaDePrecoPadrao(), Frete())
    val produto = Compra(30.00, "SAO PAULO")

    val calcula = calculadoraDePrecos.calcula(produto)

    println("Preço: R$ $calcula")
}

// OCP - Princípio de aberto para extensão e fechado para modificação.
// Faz uso da abstração que será utilizada pela implementação(a extensão), uma nova implementação pode ser adicionada sem que seja
// necessário alterar a classe atual (fechada para alteração). Torna a classe mais coesa.

// DIP - Princípio da inversão de dependências, se refere ao uso de módulo mais estáveis que a atual.
// Abstrações fazem uso de abstrações, implementações utilizam as abstrações.
// Abstrações são mais estáveis e diminuim o risco de propagação de problemas.