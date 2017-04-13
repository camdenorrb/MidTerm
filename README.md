
To Test `mvn clean test`

To Build: `mvn clean package`

To compile and install on your local maven repo: `mvn clean package install`


If Test or Build fails saying "Address already in use", try closing the Java instance and try again.


To start the server (You can also not provide the ip and port for default values.)
```
java -jar MidtermTest-1.0-jar-with-dependencies 127.0.0.1 9092
```

127.0.0.1 being the ip and 9092 being the port, change to your liking.


SocketIO Channels: { FibErr (Errors), FibResp (Response) }


Client packet order: Connect -> Send calc request -> Receive response or error


Libraries:
  - Netty (https://netty.io)
  - SLF4J (https://www.slf4j.org)
  - Kotlin (https://kotlinlang.org)
  - SocketIO Server (https://github.com/mrniko/netty-socketio)
  - Jackson (https://github.com/FasterXML/jackson)
  - Json (https://mvnrepository.com/artifact/org.json/json)
  - SocketIO Client (https://github.com/socketio/socket.io-client-java)
  - OkHttp (https://github.com/square/okhttp)
  - Junit (http://junit.org/junit4/)
  - Hamcrest Core (https://mvnrepository.com/artifact/org.hamcrest/hamcrest-core)
  - Okio (https://github.com/square/okio)

  