package com.grupo.biblioteca.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.EventObject;

import org.apache.log4j.Logger;

import com.grupo.biblioteca.server.events.ConnectionClientEvent;
import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.biblioteca.server.events.Notifier;

public class ConnectionServer extends Notifier implements Runnable, Notificable {

    static Logger log = Logger.getLogger(ConnectionServer.class);
    /**
	 * @uml.property  name="clientSocket"
	 */
    private Socket clientSocket;
    /**
	 * @uml.property  name="serverSocket"
	 */
    private ServerSocket serverSocket;
    /**
	 * @uml.property  name="alive"
	 */
    private boolean alive = true;

    public ConnectionServer() {
	start();
    }

    public void run() {
	log.debug("Inicializando puerta 5500");
	try {
	    this.serverSocket = new ServerSocket(5500);
	    log.debug("Escuchando puesrta 5500.");
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
	while (this.alive)
	    try {

		InetAddress thisIp = InetAddress.getLocalHost();

		log.debug("Esperando conexión " + thisIp.getHostAddress()
			+ ":5500.");
		this.clientSocket = this.serverSocket.accept();
		notify(new ConnectionClientEvent(this, new ConnectionClient(
			this.clientSocket, this)));
		log.debug("Cliente conectado desde "
			+ this.clientSocket.getInetAddress().toString() + ".");
	    } catch (IOException localIOException1) {
	    }
    }

    public void start() {
	Thread t = new Thread(this);
	t.start();
    }

    public void handle(EventObject event) {
	notify(event);
    }

    public void finish() {
	this.alive = false;
	try {
	    this.serverSocket.close();
	} catch (IOException localIOException) {
	}
    }

}