package shelter

import java.math.MathContext
import kotlin.random.Random

typealias num = java.math.BigDecimal

fun main() {

    val precision = run {
        print("what accuracy?\n[in]: ")
        readLine()!!.toUIntOrNull() ?: run {
            println("[error]: could not parse number!")
            println("[info]: using default value instead.")
            128u
        }
    }.toInt()

    val points = run {
        print("how many points?\n[in]: ")
        readLine()!!.toUIntOrNull() ?: run {
            println("[error]: could not parse number!")
            println("[info]: using default value instead.")
            1000u
        }
    }.toInt()

    val mathCtx = MathContext(precision)

    val one = num(1)
    var pointsInside = num(0)
    var totalPoints = num(0)


    fun randNum(): num {
        val randStr = buildString() {
            append("0.")
            for (i in 0 until precision)
                append(Random.nextInt(10))
        }
        return num(randStr)
    }

    repeat(points) {
        val x = randNum()
        val y = randNum()

        if (x.pow(2) + y.pow(2) <= one)
            pointsInside += one;
        
        totalPoints += one
    }

    val pi = num(4) * pointsInside.divide(totalPoints, mathCtx)
    
    println("PI: ${pi}")
}
