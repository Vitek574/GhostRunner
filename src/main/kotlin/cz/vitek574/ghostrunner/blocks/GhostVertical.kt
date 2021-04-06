package cz.vitek574.ghostrunner.blocks

import cz.vitek574.ghostrunner.Block
import cz.vitek574.ghostrunner.Neighbors
import cz.vitek574.ghostrunner.Position
import kotlin.random.Random

class GhostVertical(override val position: Position) : Block {
    override fun getRenderChar(): Char {
        return '⭘'
    }

    override fun step(neighbors: Neighbors) {
        val nextInt = Random.nextInt(0, 2)
        when (nextInt) {
            0 -> if (neighbors.top is Whitespace) position.posY -= 1
            else if (neighbors.top is Hero)
                println("hrdina přišel o život")
            else if  (neighbors.top is Wall) position.posY += 1
            1 -> if (neighbors.bottom is Whitespace) position.posY += 1
            else if (neighbors.bottom is Hero)
                println("hrdina přišel o život")
            else if  (neighbors.left is Wall) position.posY -= 1

        }
    }
}