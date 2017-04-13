package me.camdenorrb.midtermtest.socket

import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.DataListener
import io.netty.util.concurrent.Future
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by camdenorrb on 4/12/17.
 */

// The main server
class Server(ip: String, port: Int): SocketIOServer(Configuration().apply { this.hostname = ip; this.port = port }) {

	// Keep track of the start status privately and atomically.
	private var started = AtomicBoolean(false)

	// Check if the server is running atomically.
	fun isRunning() = started.get()


	// Stop the server if it is started.
	override fun stop() {
		if (isRunning()) super.stop().also { started.set(false) }
	}

	// Start the server if it isn't running.
	override fun start() {
		if (isRunning().not()) super.start().also { started.set(true) }
	}

	// Start the server asynchronously if it isn't running.
	override fun startAsync(): Future<Void>? {
		return if (isRunning().not()) super.startAsync().also { started.set(true) } else null
	}


	// Add a listener in a Kotlin friendly fashion.
	inline fun <reified T: Any> addListener(channel: String, listener: DataListener<T>) {
		this.addEventListener(channel, T::class.java, listener)
	}

}