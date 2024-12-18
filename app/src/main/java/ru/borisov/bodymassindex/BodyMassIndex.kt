package ru.borisov.bodymassindex

class BodyMassIndex(
    private val height: Double,
    private val weight: Double,
) {
    fun calculate(): Double = weight / (height / 100 * height / 100)
}