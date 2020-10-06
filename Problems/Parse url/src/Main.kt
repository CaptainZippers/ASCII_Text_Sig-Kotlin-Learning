import java.util.*

fun main() {
    val input = Scanner(System.`in`).nextLine()
    val inputArrayObject = input.substringAfter('?').split('&')
    var pass = ""
    for (i in 0..inputArrayObject.lastIndex) {
        var keyValuePair = inputArrayObject[i].split('=')
        if (keyValuePair[1] == "") keyValuePair = listOf(keyValuePair[0], "not found")
        if (keyValuePair[0] == "pass" && keyValuePair[1] != "not found") pass = keyValuePair[1]
        println("${keyValuePair[0]} : ${keyValuePair[1]}")
    }
    if (pass != "") print("password : $pass")
}
