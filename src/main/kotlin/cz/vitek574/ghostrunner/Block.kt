package cz.vitek574.ghostrunner

interface Block {
    val position : Position

    fun getRenderChar() : Char

    fun step(neighbors: Neighbors)
}