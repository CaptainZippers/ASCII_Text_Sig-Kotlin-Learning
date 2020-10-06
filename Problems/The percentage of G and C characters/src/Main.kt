import java.util.*

fun main() {
    val str = Scanner(System.`in`).next()
    var gc = 0
    for (i in 0..str.lastIndex) {
        if (str[i] in charArrayOf('g','c','G','C')) gc++
    }
    print(gc.toDouble() * 100 / str.length)
}
