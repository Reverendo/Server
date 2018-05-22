/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicServer;


/**
 *
 * @author mentat
 */
class ServerThread implements Runnable {
  MyStreamSocket myDataSocket;

  /**
   * 
   * @param myDataSocket 
   */
  ServerThread(MyStreamSocket myDataSocket) {
    this.myDataSocket = myDataSocket;
  }
  /**
   *   
   */
  public void run( ) {
    String message;
    try {
         System.out.println("En el run");
         myDataSocket.gestorPeticiones();
         myDataSocket.close();
         
      } 
      
    catch (Exception ex) {
      System.out.println("Exception caught in thread: " + ex);
    } 
  } //end run
} //end class 
