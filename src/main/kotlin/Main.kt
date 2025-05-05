import java.io.File

fun main() {
    val inputCells = readInput()
    simulate(inputCells)
}

// reads the input from file from root directory
private fun readInput(): List<Pair<Long, Long>> {
    val liveCells = mutableSetOf<Pair<Long, Long>>()
    val file = File("input.txt")

    file.forEachLine { line ->
        if (line.startsWith("#") || line.isBlank()) return@forEachLine

        val parts = line.trim().split(" ")
        val x = parts[0].toLong()
        val y = parts[1].toLong()
        liveCells.add(x to y)
    }

    return liveCells.toList()
}

private fun simulate(inputCells: List<Pair<Long, Long>>, simulations: Int = 10) {
    val liveCells = inputCells.toMutableSet()

    // the 8 neighbour offsets
    val neighborOffsets = listOf(
        -1L to -1L, 0L to -1L, 1L to -1L,
        -1L to 0L, 1L to 0L,
        -1L to 1L, 0L to 1L, 1L to 1L
    )

    repeat(simulations) {
        val neighborCounts = mutableMapOf<Pair<Long, Long>, Int>()

        // for each live cell we create/bump its 8 neighbors
        for ((x, y) in liveCells) {
            for ((offsetX, offsetY) in neighborOffsets) {
                val neighbor = (x + offsetX) to (y + offsetY)
                neighborCounts[neighbor] = neighborCounts.getOrDefault(neighbor, 0) + 1
            }
        }

        // apply rules for live cells and get what's currently valid
        val newLiveCells = mutableSetOf<Pair<Long, Long>>()
        for ((cell, count) in neighborCounts) {
            if (count == 3 || (count == 2 && cell in liveCells)) {
                newLiveCells.add(cell)
            }
        }

        liveCells.clear()
        liveCells.addAll(newLiveCells)
    }

    println("#Life 1.06")
    for ((x, y) in liveCells) {
        println("$x $y")
    }
}