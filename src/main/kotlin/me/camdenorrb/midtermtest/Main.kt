package me.camdenorrb.midtermtest

import me.camdenorrb.midtermtest.listeners.CalcFibListener
import me.camdenorrb.midtermtest.socket.Server

/**
 * Created by camdenorrb on 4/12/17.
 */

fun main(args: Array<String>) {

	// Get the port from the JVM args or go to default.
	val port = args.getOrNull(0)?.toIntOrNull() ?: 9092

	// Get the Ip from the JVM args or go to default.
	val ip = args.getOrNull(1) ?: "127.0.0.1"

	// Initialize the server and add default listeners.
	val server = Server(ip, port).apply { this.addListener("CalcFib", CalcFibListener()) }

	// Start the server.
	server.start()

	println("Server started on $ip:$port")

}