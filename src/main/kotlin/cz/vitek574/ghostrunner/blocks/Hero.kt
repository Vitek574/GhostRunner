package cz.vitek574.ghostrunner.blocks

import cz.vitek574.ghostrunner.Block
import cz.vitek574.ghostrunner.Neighbors
import cz.vitek574.ghostrunner.Position
import kotlin.random.Random

class Hero(override val position: Position) : Block {
    override fun getRenderChar() : Char {
        return '@'
    }

    override fun step(neighbors: Neighbors) {
        val nextInt = Random.nextInt(0, 4)
        when (nextInt) {
            0 -> if (neighbors.bottom is Whitespace) position.posY += 1
            else if (neighbors.bottom is GhostHorizontal)
                println("hrdina přišel o život")
            else if (neighbors.bottom is Finish)
                println("gratuluji vyhrál jsi")
            else println("tak nic já nemůžu jít")
            1 -> if (neighbors.left is Whitespace) position.posX -= 1
            else if (neighbors.left is GhostHorizontal)
                println("hrdina přišel o život")
            else if (neighbors.left is Finish)
                println("gratuluji vyhrál jsi")
            else println("tak nic já nemůžu jít")
            2 -> if (neighbors.right is Whitespace) position.posX += 1
            else if (neighbors.right is GhostHorizontal)
                println("hrdina přišel o život")
            else if (neighbors.right is Finish)
                println("gratuluji vyhrál jsi")
            else println("tak nic já nemůžu jít")
            3 -> if (neighbors.top is Whitespace) position.posY -= 1
            else if (neighbors.top is GhostHorizontal)
                println("hrdina přišel o život")
            else if (neighbors.top is Finish)
                println("gratuluji vyhrál jsi")
            else println("tak nic já nemůžu jít")
        }
    }
}