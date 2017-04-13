package me.camdenorrb.midtermtest.listeners

import com.corundumstudio.socketio.AckRequest
import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.listener.DataListener
import me.camdenorrb.midtermtest.serializable.FibonacciError
import me.camdenorrb.midtermtest.struct.FibonacciIndex

/**
 * Created by camdenorrb on 4/12/17.
 */

// A listener for calculating nth number in the Fibonacci sequence.
class CalcFibListener : DataListener<FibonacciIndex> {

	// When data incomes
	override fun onData(client: SocketIOClient, data: FibonacciIndex, ackSender: AckRequest?) {

		// Log that it received a thing.
		println("Received an index request: ${data.index}")

		// Send back a error if index is a negative.
		if (data.index < 0) return client.sendEvent("FibErr", FibonacciError("Negative number provided!"))

		// Get the nth number in the Fibonacci sequence.
		val calcFib = data.calcFib()

		// If the nth number is negative due to how big it is, send back a error.
		if (calcFib < 0) return client.sendEvent("FibErr", FibonacciError("The index you provided was too big to be returned in Fib sequence."))

		// Send back the calculated nth number.
		client.sendEvent("FibResp", calcFib)

	}

}