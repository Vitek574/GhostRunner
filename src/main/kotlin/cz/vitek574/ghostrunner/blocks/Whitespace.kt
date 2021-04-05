package cz.vitek574.ghostrunner.blocks

import cz.vitek574.ghostrunner.Block
import cz.vitek574.ghostrunner.Neighbors
import cz.vitek574.ghostrunner.Position

class Whitespace(override val position: Position) : Block {
    override fun getRenderChar() : Char {
        return ' '
    }
    override fun step(neighbors: Neighbors) {
    }
}