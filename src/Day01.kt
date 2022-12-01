fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        val list  = mutableListOf<Int>()

            input.forEach {
            if (it.isNotEmpty()) {
                sum += it.toInt()
            } else{
                list.add(sum)
                sum =0
            }
        }
        return list.max()
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        val list  = mutableListOf<Int>()

        input.forEach {
            if (it.isNotEmpty()) {
                sum += it.toInt()
            } else {
                list.add(sum)
                sum =0
            }
        }
        if (input.last().isNotEmpty()){
            list.add(input.last().toInt())
        }
        val sortedList = list.sortedByDescending { it }
        return sortedList[0] + sortedList[1] + sortedList[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
