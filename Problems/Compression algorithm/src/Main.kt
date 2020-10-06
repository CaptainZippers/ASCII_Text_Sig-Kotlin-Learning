import java.util.*

fun main() {
    val input = Scanner(System.`in`).next()
    var out = ""
    var count = 1
    for (i in 0..input.lastIndex) {
        if (i == 0 || input[i] != input[i - 1]) {
            if (i != 0) {
                out += count.toString()
                count = 1
            }
            out += input[i]
        } else if (input[i] == input[i - 1]) count++
    }
    out += count.toString()
    print(out)
}
