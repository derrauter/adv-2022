fun main() {

    fun String.asIntRange(): IntRange =
        substringBefore("-").toInt() .. substringAfter("-").toInt()

    fun String.asRanges(): Pair<IntRange,IntRange> =
    substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

    infix fun IntRange.fullyOverlaps(other: IntRange): Boolean =
        first <= other.first && last >= other.last

    infix fun IntRange.overlaps(other: IntRange): Boolean =
        first <= other.last && other.first <= last

    fun part1(input: List<String>): Int {
        val ranges: List<Pair<IntRange,IntRange>> = input.map { it.asRanges() }

        return ranges.count { it.first fullyOverlaps it.second || it.second fullyOverlaps it.first  }
    }





    fun part2(input: List<String>): Int {
        val ranges: List<Pair<IntRange,IntRange>> = input.map { it.asRanges() }

        return ranges.count { it.first overlaps it.second || it.second overlaps it.first  }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")


    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
