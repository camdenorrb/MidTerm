package me.camdenorrb.midtermtest.socket

import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.DataListener
import io.netty.util.concurrent.Future

/**
 * Created by camdenorrb on 4/12/17.
 */

const val alreadyStopped = "Attempted to stop a already stopped server!"
const val alreadyStarted = "Attempted to start a already started server!"

// The main server
class Server(ip: String, port: Int): SocketIOServer(Configuration().apply { this.hostname = ip; this.port = port }) {

	// Keep track of the start status privately and in a volatile fashion.
	@Volatile var started = false
		private set


	// Stop the server if it is started.
	override fun stop() {
		check(started) { alreadyStopped }
		super.stop().also { started = false }
	}

	// Start the server if it isn't running.
	override fun start() {
		check(started.not()) { alreadyStarted }
		super.start().also { started = true }
	}

	// Start the server asynchronously if it isn't running.
	override fun startAsync(): Future<Void> {
		check(started.not()) { alreadyStarted }
		return super.startAsync().also { started = true }
	}


	// Add a listener in a Kotlin friendly fashion.
	inline fun <reified T: Any> addListener(channel: String, listener: DataListener<T>) {
		this.addEventListener(channel, T::class.java, listener)
	}

}