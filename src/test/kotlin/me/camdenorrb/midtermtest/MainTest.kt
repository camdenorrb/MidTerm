package me.camdenorrb.midtermtest

import io.socket.client.IO
import me.camdenorrb.midtermtest.listeners.CalcFibListener
import me.camdenorrb.midtermtest.socket.Server
import me.camdenorrb.midtermtest.struct.FibonacciIndex
import org.json.JSONObject
import org.junit.Test

/**
 * Created by camdenorrb on 4/12/17.
 */

internal class MainTest {

	// Create a client that points to the local server.
	val socket = IO.socket("http://127.0.0.1:9092")!!

	// Initialize the server and add default listeners.
	val server = Server().apply { this.addListener("CalcFib", CalcFibListener()) }


	@Test
	fun test() {

		// On response, print the toString version of it.
		socket.on("FibResp", { println("Response: ${it.firstOrNull()}") })

		// On error, print the toString version of it, close the server which ends the test.
		socket.on("FibErr", { println("Error: ${it.firstOrNull()}"); server.stop() })

		// Send a couple CalcFib tests.
		socket.on("connect", {
			socket.emit("CalcFib", JSONObject(FibonacciIndex(0)))
			socket.emit("CalcFib", JSONObject(FibonacciIndex(1)))
			socket.emit("CalcFib", JSONObject(FibonacciIndex(2)))
			socket.emit("CalcFib", JSONObject(FibonacciIndex(10)))
			socket.emit("CalcFib", JSONObject(FibonacciIndex(-20)))
		})

		// Start the server instance.
		server.start()

		// Connect to the server instance from the client.
		socket.connect()

		// Waits until the server stops
		while (server.isRunning()) {}

	}

}