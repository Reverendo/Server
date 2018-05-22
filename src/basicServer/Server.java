/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicServer;

import java.net.ServerSocket;

/**
 *
 * @author mentat
 */
public class Server {
    /**
     * 
     * @param args 
     */
  public static void main(String[] args) {
    int serverPort = 5000;   // default port
    String message;

    try {
      // instantiates a stream socket for accepting connections
        ServerSocket myConnectionSocket = new ServerSocket(serverPort); 
      while (true) {  // Bucle infinito
        // esperamos una conexión y cuando llegue la aceptamos
        MyStreamSocket myDataSocket = new MyStreamSocket(myConnectionSocket.accept( ));
        
        System.out.println("Conexion recibida");
        // Iniciamos un hilo que gestionará la conexión con el cliente
        Thread theThread = new Thread(new ServerThread(myDataSocket));
        theThread.start();
        // Esperamos al siguiente cliente
      } //final bucle
    } //final try 

    catch (Exception ex) {
       ex.printStackTrace( );
    } 
  } //final main
} // final class
