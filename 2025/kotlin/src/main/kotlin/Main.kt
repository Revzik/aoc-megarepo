import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.optional
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val parser = ArgParser("aoc-2025")
    val dayToRun by parser.argument(
        ArgType.Int,
        fullName = "day",
        description = "day to run, if not provided, executes all puzzle solutions"
    ).optional()
    parser.parse(args)

    if (dayToRun == null) {
        runAllSolutions()
        return
    }

    when (dayToRun) {
        1 -> day01.run()
        2 -> day02.run()
        3 -> day03.run()
        4 -> day04.run()
        5 -> day05.run()
        else -> errorExit("Possible days to run are 1-5")
    }
}

fun runAllSolutions() {
    day01.run()
    println()

    day02.run()
    println()

    day03.run()
    println()

    day04.run()
    println()

    day05.run()
}

fun errorExit(message: String) {
    println(message)
    exitProcess(1)
}