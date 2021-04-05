package cz.vitek574.ghostrunner.blocks

import cz.vitek574.ghostrunner.Block
import cz.vitek574.ghostrunner.Neighbors
import cz.vitek574.ghostrunner.Position
import kotlin.random.Random

class GhostHorizontal(override val position: Position) : Block {
    override fun getRenderChar(): Char {
        return '⭘'
    }

    override fun step(neighbors: Neighbors) {
        val nextInt = Random.nextInt(0, 2)
        when (nextInt) {
            0 -> if (neighbors.left is Whitespace) position.posX -= 1
            else if (neighbors.left is Hero)
                println("hrdina přišel o život")
            else if  (neighbors.left is Wall) position.posX += 1
            1 -> if (neighbors.right is Whitespace) position.posX += 1
            else if (neighbors.right is Hero)
                println("hrdina přišel o život")
            else if (neighbors.left is Wall) position.posX -= 1
        }
    }
}
