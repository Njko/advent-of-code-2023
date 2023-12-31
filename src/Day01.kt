fun main() {
    fun getDigitsFromLine(line: String): Int {
        val firstDigit = line.find { it.isDigit() } ?: 0
        val lastDigit = line.findLast { it.isDigit() } ?: 0

        return "$firstDigit$lastDigit".toInt()
    }

    fun getNamedDigitsFromLine(line: String): Int {
        var digitifiedLine = line
        val numberMap = mapOf(
            "zero" to "0", "one" to "1", "two" to "2", "three" to "3",
            "four" to "4", "five" to "5", "six" to "6", "seven" to "7",
            "eight" to "8", "nine" to "9",
        )

        numberMap.keys.forEach {
            digitifiedLine = digitifiedLine.replace(it, numberMap[it] ?: "")
        }

        val digits = digitifiedLine.filter { it.isDigit() }
        val firstDigit = digits.firstOrNull()?.toString() ?: "0"
        val lastDigit = digits.lastOrNull()?.toString() ?: "0"

        return "$firstDigit$lastDigit".toInt()
    }

    fun part1(input: List<String>): Int {
        return input.fold(0) { accumulator, currentString ->
            accumulator + getDigitsFromLine(currentString)
        }
    }

    fun part2(input: List<String>): Int {
        return input.fold(0) { accumulator, currentString ->
            accumulator + getNamedDigitsFromLine(currentString)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)
    val testInputPart2 = readInput("Day01_test2")
    check(part2(testInputPart2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
