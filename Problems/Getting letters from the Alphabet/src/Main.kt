import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    var character = input.next().first().toChar()
    for (i in 'a' until character) print(i)
}
