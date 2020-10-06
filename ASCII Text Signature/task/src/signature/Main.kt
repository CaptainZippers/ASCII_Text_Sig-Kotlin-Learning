package signature

import java.io.File
import java.util.*

fun main() {
    Tag().printTag()
}
class Tag {
    class StylizedText( font: Scanner, private var string:CharArray) {
        val height: Int
        private val numberOfCharacters: Int
        var stylizedText: MutableList<String>
        class AlphabetCharacters(val char: Char, val definition: MutableList<String>)
        private var alphabet: MutableSet<AlphabetCharacters> = mutableSetOf()
        private fun addLetter(character: AlphabetCharacters) {
            for (i in 0 until height) {
                this.stylizedText[i] = "${this.stylizedText[i]}${character.definition[i]}"
            }
        }
        init {
            val firstLine = font.nextLine().split(" ")
            this.height = firstLine[0].toInt()
            this.numberOfCharacters = firstLine[1].toInt()
            this.stylizedText = mutableListOf<String>().apply { repeat(height){this.add("")} }
//            Construct Alphabet
            for (i in 0 until numberOfCharacters) {
                val nextLine = font.nextLine().split(" ")
                val char = nextLine[0].toCharArray().first()
                val width = nextLine[1].toInt()
                val definition: MutableList<String> = mutableListOf()
                for (j in 0 until height) {
                    definition.add(font.nextLine())
                }
                if (char == 'a') {
                    val spaceDefinition = mutableListOf<String>().apply { repeat(height){this.add(" ".repeat(width))} }
                    this.alphabet.add(AlphabetCharacters(' ', spaceDefinition))
                }
                this.alphabet.add(AlphabetCharacters(char, definition))
            }
//            Convert string to stylized string now that we have an alphabet to write with
            characters@ for (i in 0..this.string.lastIndex) {
                val char = if (!this.string[i].isWhitespace()) this.string[i] else ' '
                this.addLetter(this.alphabet.find { it.char == char}!!)
            }
        }
    }
    private var nameEven = 0
    private var nameOffset = 0
    private val name: CharArray
    private var stylizedName: StylizedText
    private var vocationEven = 0
    private var vocationOffset = 0
    private val vocation: CharArray
    private var stylizedVocation: StylizedText
    private var longestLine = 0
    init {
        val input = Scanner(System.`in`)
        print("Enter name and surname: ")
        name = input.nextLine().toCharArray()
        print("Enter person's status: ")
        vocation = input.nextLine().toCharArray()
        stylizedName = StylizedText(Scanner(File("C:\\Users\\afrom\\Downloads\\roman.txt")), name)
        stylizedVocation = StylizedText(Scanner(File("C:\\Users\\afrom\\Downloads\\medium.txt")), vocation)
        this.compareStylizedText()
    }
    private fun compareStylizedText() { // Used to set offsets
        if (this.stylizedName.stylizedText[0].length > this.stylizedVocation.stylizedText[0].length) {
            this.vocationOffset = (this.stylizedName.stylizedText[0].length - this.stylizedVocation.stylizedText[0].length) / 2
            this.vocationEven = (this.stylizedName.stylizedText[0].length - this.stylizedVocation.stylizedText[0].length) % 2
        } else {
            this.nameOffset = (this.stylizedVocation.stylizedText[0].length - this.stylizedName.stylizedText[0].length) / 2
            this.nameEven = (this.stylizedVocation.stylizedText[0].length - this.stylizedName.stylizedText[0].length) % 2
        }
        this.longestLine = if (this.vocationOffset > this.nameOffset) {
            this.stylizedName.stylizedText[0].length
        } else this.stylizedVocation.stylizedText[0].length
    }
    fun printTag() {
        println("8".repeat(this.longestLine + 8))
        for (i in 0 until this.stylizedName.height){
            println("88${" ".repeat(this.nameOffset + 2)}${this.stylizedName.stylizedText[i]}${" ".repeat(this.nameOffset + this.nameEven + 2)}88")
        }
        for (i in 0 until this.stylizedVocation.height) {
            println("88${" ".repeat(this.vocationOffset + 2)}${this.stylizedVocation.stylizedText[i]}${" ".repeat(this.vocationOffset + this.vocationEven + 2)}88")
        }
        println("8".repeat(this.longestLine + 8))
    }
}
