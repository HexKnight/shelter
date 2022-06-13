package shelter

data class Product(val name: String, val price: Int)

val products =
    listOf(
        Product("Bread", 1),
        Product("Croissant", 1),
        Product("Sugar Roll", 2),
        Product("Palma", 2),
        Product("Donut", 3),
        Product("Small Cake", 5),
        Product("Chocolate Cake", 40),
        Product("Wedding Cake", 200),
    )

fun main() {

    println("Welcome to Bakery!")
    println("please select whatever you need!\n")

    val basket = linkedMapOf<Product, Int>()

    while (true) {
        products.forEachIndexed { index, item ->
            println("(${index+1}): ${item.name} ${item.price}\$")
        }
        println("(b): basket")
        println("(d): done")
        println("(q): quit\n")

        when (val option = run {
            print("[in]: ")
            readLine()!!.takeWhile { it != ' ' }
        }) {

            "q" -> {
                println("exiting Bakery..")
                break
            }

            "b" -> {
                if (basket.isEmpty())
                    print("[info]: your basket is empty.")
                else {
                    println("[info]: your basket contains:")
                    for ((product, amount) in basket)
                        println("-$amount ${product.name} for ${product.price * amount}\$")
                }
            }

            "d" -> {
                var cost = 0

                if (basket.isEmpty())
                    println("[info]: your basket is empty.")
                else {
                    println("[info]: your basket contains:")
                    for ((product, amount) in basket) {
                        println("-$amount ${product.name} for ${product.price * amount}\$")
                        cost += amount * product.price
                    }
                }

                println("is that it? (y/n)")
                val input = run {
                    print("[in]: ")
                    readLine()!!.takeWhile { it != ' ' }
                }

                if (input == "y") {
                    if (cost > 0)
                        println("[info]: that would be $cost\$")
                    println("thank you for your visit.")
                    print("come back again!")
                    readLine()
                    break
                } else
                    continue
            }

            in ((1..products.size).map(Int::toString)) -> {

                val item = products[option.toInt()-1]
                println("of course, how much of ${item.name} do you want?")

                val amount: Int = run {
                    print("[in]: ")
                    readLine()!!.toIntOrNull() ?: run {
                        print("[error]: couldn't parse number!")
                        0
                    }
                }

                if (amount > 0) {
                    basket[item] = (basket[item] ?: 0) + amount
                    print("[info]: successfuly added $amount ${item.name} to you basket!")
                } else if (amount < 0)
                    print("[error]: amount must be positive!")
            }

            else -> print("[error]: unknown option!")
        }

        readLine()
    }
}
