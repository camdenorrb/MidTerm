package me.camdenorrb.midtermtest.struct

/**
 * Created by camdenorrb on 4/12/17.
 */

// A class to hold the index.
data class FibonacciIndex(val index: Int = 0) {

	// Calculates the index in the Fibonacci sequence
	fun calcFib() = calcFib(index)

	// private fun calcFib(index: Int): Int = if (index <= 1) index else calcFib(index - 1) + calcFib(index - 2)

	// Performance favorable way to calculate the nth number in the Fibonacci sequence.
	fun calcFib(index: Int): Long {

		var returned = 0L
		var cache = 1L

		for (i in 2..index) {
			val temp = returned
			returned += cache
			cache = temp
		}

		return returned
	}

}