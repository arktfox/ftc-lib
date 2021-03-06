package io.arct.ftclib.extentions

import kotlin.math.round

/**
 * Rounds a double to N decimal places
 *
 * @param decimals Amount of decimal places to round to
 *
 * @return The rounded decimal
 */
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier).toInt() / multiplier
}

fun Double.min(bound: Double): Double =
    if (this < bound) bound else this

fun Double.max(bound: Double): Double =
    if (this > bound) bound else this

fun Double.map(from: ClosedRange<Double>, to: ClosedRange<Double>): Double =
    if (to.start <= to.endInclusive) (this - from.start) * (to.endInclusive - to.start) / (from.endInclusive - from.start) + to.start
    else (to.endInclusive + to.start) - this.map(from, (to.endInclusive)..(to.start))
