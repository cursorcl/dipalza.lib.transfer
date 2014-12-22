package com.grupo.biblioteca.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.grupo.biblioteca.server.events.ConnectionClientEvent;
import com.grupo.biblioteca.server.events.ConnectionServerEvent;
import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.biblioteca.server.events.Notifier;

public class ConnectionServer extends Notifier implements Runnable, Notificable {

  static Logger log = Logger.getLogger(ConnectionServer.class);
  /**
   * @uml.property name="clientSocket"
   */
  private Socket clientSocket;
  /**
   * @uml.property name="serverSocket"
   */
  private ServerSocket serverSocket;
  /**
   * @uml.property name="alive"
   */
  private boolean alive = true;
  private String bind = "127.0.0.1";
  private String eth = "eth0";

  public ConnectionServer() {
    InputStream inStream = ConnectionServer.class.getResourceAsStream("/sqlserver.properties");
    if (inStream != null) {
      try {
        Properties props = new Properties();
        props.load(inStream);
        bind = props.getProperty("bind", bind);
        props = null;
        inStream.close();
      } catch (IOException e) {
        log.error("Se ha establecido la dirección IP por defecto para escuchar");
      }

    }
    start();
  }

  public void run() {
    InetAddress thisIp =null;
    log.debug("Inicializando puerta 5500");
    try {
      
      Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
      while (en.hasMoreElements()) {
        NetworkInterface ni = en.nextElement();
        List<InterfaceAddress> list = ni.getInterfaceAddresses();
        if (ni.getName().equals("eth0")) {
          Iterator<InterfaceAddress> it = list.iterator();
          while (it.hasNext()) {
            InterfaceAddress ia = it.next();
            thisIp = ia.getAddress();
            log.info(ia.getAddress().toString());
            break;
          }
          break;
        }
      }
      if(thisIp == null)
      {
        thisIp = InetAddress.getByName(bind);
      }

      this.serverSocket = new ServerSocket(5500, 5, thisIp);
      notify(new ConnectionServerEvent(this, serverSocket)); //Notificamos la conexion
      log.debug("Escuchando puesrta 5500.");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    while (this.alive)
      try {
        log.debug("Esperando conexión " + thisIp.toString() + ":5500.");
        this.clientSocket = this.serverSocket.accept();
        notify(new ConnectionClientEvent(this, new ConnectionClient(this.clientSocket, this)));
        log.debug("Cliente conectado desde " + this.clientSocket.getInetAddress().toString() + ".");
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
