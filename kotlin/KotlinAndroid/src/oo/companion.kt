package oo



interface HouseFactory{
    fun createHouse() : House
}

class House(val numberOfRooms: Int, val price: Double ){

    // Equivalente ao static em Java, a diferença é que permite implementar interfaces
    companion object : HouseFactory {

        val HOUSE_FOR_SALES = 10 // variável estática

        fun getNormalHouse() = House(6, 199_999.0)
        fun getLuxuryHouse() = House(42, 7_199_999.0)

        override fun createHouse(): House {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}


fun main(args: Array<String>) {

    val normalHouse = House.getNormalHouse()


    println(normalHouse.price)

    println(House.HOUSE_FOR_SALES)
}