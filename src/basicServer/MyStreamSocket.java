/*
 * Version que recibe directamente la consultaPorIdCliente SQL como un String
 * Segun la primera palabra clave (SELECT, INSERT, UPDATE, DELETE)
 * Llama a un metodo u otro de conexion BD
 */
package basicServer;

/**
 *
 * @author mentat
 */
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyStreamSocket extends Socket {
  private Socket  socket;
  public ObjectOutputStream oos;
  private DataOutputStream output;
  private DataInputStream input;
  private BufferedReader input2;
  /**
   * 
   * @param acceptorHost
   * @param acceptorPort
   * @throws SocketException
   * @throws IOException 
   */
  
  //Constructor que recibe dirección de internet y puerto
  MyStreamSocket(InetAddress acceptorHost, int acceptorPort ) 
          throws SocketException, IOException{
    socket = new Socket(acceptorHost, acceptorPort );
    setStreams( );
  }
  /**
   * 
   * @param socket
   * @throws IOException 
   */
  
//Constructor que recibe un socket
  MyStreamSocket(Socket socket)  throws IOException {
    this.socket = socket;
    setStreams( );
  }
  /**
   * 
   * @throws IOException 
   */
  
  //Metodo que configura un flujo de entrada y uno de salida en el socket
  private void setStreams( ) throws IOException{
    // Crear un input stream para leer datos del socket
    //InputStream inStream = socket.getInputStream();
    
    // Crear un output stream para enviar datos por el socket
    //OutputStream outStream = socket.getOutputStream();
    
    output = new DataOutputStream (socket.getOutputStream());
    input = new DataInputStream (socket.getInputStream());
    input2 = new BufferedReader (new InputStreamReader(socket.getInputStream()));
  }
  
  /**
   * 
   * @param message
   * @throws IOException 
   */
  //Metodo que recibe un mensaje y lo envía al cliente
  
  public void sendMessage(String message) throws IOException {  
    output.writeUTF(message);  
    output.flush();          
  } // end sendMessage
public void gestorPeticiones() {
	// TODO Auto-generated method stub
	
}
  

      
} //end class



