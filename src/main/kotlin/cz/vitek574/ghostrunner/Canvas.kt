package cz.vitek574.ghostrunner

class Canvas(private val level: Level) {

    public fun redraw() {
        clear()
        for (posY in 0..level.height - 1) {
            for (posX in 0..level.width - 1) {
                val block = level.getBlock(posX, posY)
                print(block.getRenderChar())
            }
            println()
        }

        level.doSteps()
    }

    private fun clear() {
        print("\u001b[H\u001b[2J")
    }
}