package com.example.cordyx.ui.components

data class XpState(
    val currentXp: Int = 0,
    val xpToNextLevel: Int = 100,
    val level: Int = 0
){
    fun addXp(amount: Int): XpState {
        var xp = currentXp + amount
        var lvl = level
        var next = xpToNextLevel
        if (xp >= next) {
            lvl++
            xp = 0
            next = (next * 1.5).toInt()

        }
        return copy(currentXp = xp, xpToNextLevel = next, level = lvl)
    }
}
