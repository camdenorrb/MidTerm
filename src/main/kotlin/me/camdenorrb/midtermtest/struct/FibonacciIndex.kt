package me.camdenorrb.midtermtest.struct

import me.camdenorrb.midtermtest.extension.calcFib

/**
 * Created by camdenorrb on 4/12/17.
 */

// A class to hold the index.
data class FibonacciIndex(val index: Int = 0) {

	// Calculates the index in the Fibonacci sequence
	fun calcFib() = index.calcFib()

	// private fun calcFib(index: Int): Int = if (index <= 1) index else calcFib(index - 1) + calcFib(index - 2)

}