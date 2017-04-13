package me.camdenorrb.midtermtest.extension

/**
 * Created by camdenorrb on 4/13/17.
 */

// Performance favorable way to calculate the nth number in the Fibonacci sequence.
fun Int.calcFib(): Long {

	var returned = 0L
	var cache = 1L

	for (i in 2..this) {
		val temp = returned
		returned += cache
		cache = temp
	}

	return returned
}