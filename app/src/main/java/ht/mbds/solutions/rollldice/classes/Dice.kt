package ht.mbds.solutions.rollldice.classes

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}