package cz.vitek574.ghostrunner

import cz.vitek574.ghostrunner.blocks.*
import java.io.File

class Level(private val fileName: String) {

    private val dir = "src/main/resources/maps/"

    private val file = File(dir + fileName)

    private val levelDataLines = file
        .readLines()

    private val levelBlocks: List<Block> = levelDataLines
        .withIndex()
        .map { (posY, it) -> mapLineToListOfBlocks(posY, it) }
        .flatten()

    private fun mapLineToListOfBlocks(posY: Int, line: String): List<Block> {
        val blocks = mutableListOf<Block>()
        for ((posX, char) in line.withIndex()) {
            val element = mapCharToBlock(Position(posX, posY), char)
            if (element != null) {
                blocks.add(element)
            }
        }
        return blocks
    }

    private fun mapCharToBlock(position: Position, char: Char): Block? {
        return when (char) {
            '⭘' -> GhostHorizontal(position)
            '@' -> Hero(position)
            ' ' -> null
            '*' -> Finish(position)
            'O' -> GhostVertical(position)
            else -> Wall(position, char)
        }
    }

    val width: Int = levelDataLines
        .map { it.length }
        .maxOf { it }

    val height = levelDataLines.size

    val name = file
        .name
        .replace(".map", "")
        .split("-")[1]

    val number = file
        .name
        .split("-")[0]
        .toInt()

    fun getBlock(posX: Int, posY: Int): Block {
        return levelBlocks.firstOrNull { it.position.posX == posX && it.position.posY == posY } ?: Whitespace(
            Position(
                posX,
                posY
            )
        )
    }

    fun doSteps() {
        levelBlocks.forEach { it.step(mapNeighbors(it)) }
    }

    private fun mapNeighbors(block: Block): Neighbors {
        return Neighbors(
            this.getBlock(block.position.posX - 1, block.position.posY),
            this.getBlock(block.position.posX + 1, block.position.posY),
            this.getBlock(block.position.posX, block.position.posY - 1),
            this.getBlock(block.position.posX, block.position.posY + 1),
        )
    }

}