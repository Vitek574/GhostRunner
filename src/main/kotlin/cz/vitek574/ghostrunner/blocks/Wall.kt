package cz.vitek574.ghostrunner.blocks

import cz.vitek574.ghostrunner.Block
import cz.vitek574.ghostrunner.Neighbors
import cz.vitek574.ghostrunner.Position

class Wall(override val position: Position, private val charOfWall: Char) : Block {
    override fun getRenderChar() : Char {
        return charOfWall
    }

    override fun step(neighbors: Neighbors) {
    }
}