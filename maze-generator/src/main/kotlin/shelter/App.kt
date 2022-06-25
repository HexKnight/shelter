package shelter

val width = run {
    print("[in]: ")
    readLine()!!.toInt()
}
val height = run {
    print("[in]: ")
    readLine()!!.toInt()
}

fun main() {

    val name = run {
        print("what is your name? ")
        readLine()!!
    }

    println("Hello, World!\nHello, $name!")
}
