package shelter

fun main() {

    val name = run {
        print("what is your name? ")
        readLine()!!
    }

    println("Hello, World!\nHello, $name!")
}
