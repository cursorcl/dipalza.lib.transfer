package com.grupo.biblioteca.server;

import com.grupo.biblioteca.EMessagesTypes;
import com.grupo.biblioteca.IEmmiter;
import com.grupo.biblioteca.MessageToTransmit;
import com.grupo.biblioteca.server.events.MessagesClientEvent;
import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.biblioteca.server.events.Notifier;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class ConnectionClient extends Notifier implements Runnable, IEmmiter {
    static Logger log = Logger.getLogger(ConnectionClient.class.getName());
    private ObjectOutputStream objectOutput = null;
    private ObjectInputStream objectIntput = null;
    private Socket socketClient = null;
    private boolean alive = true;

    public ConnectionClient(String ip) {
        try {
            this.alive = false;
            this.socketClient = new Socket(ip, 5500);
            this.objectOutput = new ObjectOutputStream(this.socketClient.getOutputStream());
            this.objectIntput = new ObjectInputStream(this.socketClient.getInputStream());
            start();
            log.debug("Conectado al servidor e iniciado servicio");
        } catch (ConnectException e) {
            log.error("No es posible conectarse a " + ip);
        } catch (UnknownHostException e) {
            log.error("Host desconocido " + ip);
        } catch (IOException e) {
            log.error("Error de entrada/salida en " + ip);
        }
    }

    public ConnectionClient(String ip, Notificable notificable) {
        addNotificable(notificable);
        try {
            this.alive = false;
            this.socketClient = new Socket(ip, 5501);
            this.objectOutput = new ObjectOutputStream(this.socketClient.getOutputStream());
            this.objectIntput = new ObjectInputStream(this.socketClient.getInputStream());
            start();
            log.debug("Conectado al servidor e iniciado servicio");
        } catch (ConnectException e) {
            log.error("No es posible conectarse a " + ip);
        } catch (UnknownHostException e) {
            log.error("Host desconocido " + ip);
        } catch (IOException e) {
            log.error("Error de entrada/salida en " + ip);
        }
    }

    public ConnectionClient(Socket sc) {
        String ip = null;
        if (sc != null)
            ip = sc.getInetAddress().getHostName();
        try {
            this.alive = false;
            this.socketClient = sc;
            this.objectOutput = new ObjectOutputStream(this.socketClient.getOutputStream());
            this.objectIntput = new ObjectInputStream(this.socketClient.getInputStream());
            start();
            log.debug("Conectado al servidor e iniciado servicio");
        } catch (ConnectException e) {
            log.error("No es posible conectarse a " + ip);
        } catch (UnknownHostException e) {
            log.error("Host desconocido " + ip);
        } catch (IOException e) {
            log.error("Error de entrada/salida en " + ip);
        }
    }

    public ConnectionClient(Socket sc, Notificable notificable) {
        String ip = null;
        if (sc != null) {
            ip = sc.getInetAddress().getHostName();
        }
        addNotificable(notificable);
        try {
            this.alive = false;
            this.socketClient = sc;
            this.objectOutput = new ObjectOutputStream(this.socketClient.getOutputStream());
            this.objectIntput = new ObjectInputStream(this.socketClient.getInputStream());
            start();
            log.debug("Conectado al servidor e iniciado servicio");
        } catch (ConnectException e) {
            log.error("No es posible conectarse a " + ip);
        } catch (UnknownHostException e) {
            log.error("Host desconocido " + ip);
        } catch (IOException e) {
            log.error("Error de entrada/salida en " + ip);
        }
    }

    private void processData(MessageToTransmit msg) {
        switch (msg.getType()) {
            case MSG_CLIENTE:
            case MSG_DATOSINICIALIZACION:
            case MSG_ENCABEZADO:
            case MSG_NROITEMESVENTA:
            case MSG_ITEMVENTA:
            case MSG_INITIALIZE_PRODUCTO:
            case MSG_INITIALIZE_CLIENTE:
            case MSG_INITIALIZE_ESPECIALES:
            case MSG_INITIALIZE_CLIENTE_FINALIZED:
            case MSG_INITIALIZE_PRODUCTO_FINALIZED:
            case MSG_INITIALIZE_ESPECIALES_FINALIZED:
            case MSG_INFORMATIVE:
            case MSG_ESPECIALES:
            case MSG_VECTORCLIENTES:
            case MSG_VECTORPRODUCTOS:
            case MSG_VECTORVENTAS:
                notify(new MessagesClientEvent(msg.getType(), msg));
                break;
            case MSG_FINALIZED:
				try {
	                MessageToTransmit finish = new MessageToTransmit();
	                finish.setIdPalm(msg.getIdPalm());
	                finish.setType(EMessagesTypes.MSG_FINALIZED);
					this.objectOutput.writeObject(finish);
				} catch (IOException e) {

				}
            default:
                notify(null);
        }
    }

    public void run() {
        while ((this.alive) && (this.objectIntput != null))
        {
            try {
                Object obj = this.objectIntput.readObject();
                if (obj instanceof MessageToTransmit) {
                	log.info("Llega un MessageToTransmit:" + ((MessageToTransmit) obj).getType().getName());
                    processData((MessageToTransmit) obj);
                } 
                else {
                    log.error("Llega algo que no es un MessageToTransmit");
                    processData(null);
                }
            } catch (IOException ex) {
            	this.alive = false;
            	log.info("Conexión cerrada  desde el cliente.");
            } catch (ClassNotFoundException e) {
            	log.info("Conexión cerrada  desde el cliente.");
            	this.alive = false;
            }
	        try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
        }
    }

    private void start() {
        if (this.socketClient != null) {
            this.alive = true;
            Thread t = new Thread(this);
            t.start();
        }
    }

    public boolean send(MessageToTransmit obj) {
        boolean result = true;
        try {
            this.objectOutput.writeObject(obj);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public boolean send(List<MessageToTransmit> datos) {
        boolean result = true;
        try {
            for (int n = 0; n < datos.size(); ++n) {
                MessageToTransmit m = (MessageToTransmit) datos.get(n);
                this.objectOutput.writeObject(m);
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public String getSource() {
        String result = "";
        if (this.socketClient != null) {
            result = this.socketClient.getInetAddress().toString();
        }
        return result;
    }

    public void disconnect() {
        try {
            this.alive = false;
            this.socketClient.close();
            log.debug("Conexión cerrada");
        } catch (IOException e) {
            log.error("Error al cerrar la conexión.");
        }
    }

    public boolean isConnected() {
        return (this.socketClient != null) && (this.socketClient.isConnected());
    }
}
