package cz.vitek574.ghostrunner

import java.lang.Thread.sleep
import java.time.LocalDateTime

class Game(private val level: Level) {

    var started = false

    fun start() {
        val canvas = Canvas(level)
        started = true
        while(started){
            canvas.redraw()
            println(LocalDateTime.now())
            sleep( 1000)
        }
    }

    fun stop() {
        started = false
    }

}