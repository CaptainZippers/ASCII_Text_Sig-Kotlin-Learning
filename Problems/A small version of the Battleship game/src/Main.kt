import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val xCoord = IntArray(3)
    val yCoord = IntArray(3)
    for (i in 0..xCoord.lastIndex) {
        xCoord[i] = input.nextInt()
        yCoord[i] = input.nextInt()
    }
    fun printFreeCoord(usedCoord: IntArray) {
        var first = ""
        for (i in 1..5) {
            if (i !in usedCoord) {
                print("$first$i")
                first = " "
            }
        }
    }
    printFreeCoord(xCoord)
    print("\n")
    printFreeCoord(yCoord)
}
