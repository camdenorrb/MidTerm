package me.camdenorrb.midtermtest.struct

/**
 * Created by camdenorrb on 4/12/17.
 */

// A class to hold the index.

private const val sqrtFive = 2.2360679775
private const val goldenRatio = (1 + sqrtFive) / 2 

data class FibonacciIndex(val index: Int = 0) {

	// Performance favorable way to calculate the nth number in the Fibonacci sequence.
	fun calcFib(term: Int) : Long {
	    val powered = Math.pow(goldenRatio, (term + 1).toDouble())
	    return ((powered - (1 / powered)) / sqrtFive).roundToLong()
	}


	/*
	fun calcFib(): Long {		
  		  
 		var returned = 0L		
 		var cache = 1L		 
  		  
 		for (i in 2..index) {		
 			val temp = returned		
 			returned += cache		
 			cache = temp		
 		}		
  		  
 		return returned
	}*/
	
	// private fun calcFib(index: Int): Int = if (index <= 1) index else calcFib(index - 1) + calcFib(index - 2)

}
