fun main() {
    fun Char.score(): Int =
        when (this) {
            in 'a'..'z' -> (this - 'a') + 1
            in 'A'..'Z' -> (this - 'A') + 27
            else -> throw IllegalArgumentException("wrong input: $this")
        }

   fun List<String>.sharedItem(): Char =
        map { it.toSet() }
            .reduce { left, right -> left intersect right}
            .first()

     fun String.sharedItem(): Char =
        listOf(
            substring(0..length / 2),
            substring(length / 2)
        ).sharedItem()

    fun part1(input: List<String>): Int {

        return  input.sumOf { it.sharedItem().score() }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf { it.sharedItem().score() }

    }



    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
