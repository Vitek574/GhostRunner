package cz.vitek574.ghostrunner

fun main() {
    val levels = arrayOf(
        Level("01-pocatek.map"),
        Level("02-prvniVyzva.map")
    )

    val game = Game(levels[1])
    game.start()
}