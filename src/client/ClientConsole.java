package simplechat1;

import java.io.*;
import java.util.ArrayList;

import simplechat1.client.*;
import simplechat1.common.*;

/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF 
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  ChatClient client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host, int port) 
  {
    try 
    {
    	client= new ChatClient(host, port, this);
    } 
    catch(IOException exception) 
    {
    	System.out.println("Error: Can't setup connection! Terminating client.");
    	System.exit(1);
    }
  }

  
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  public void accept(ArrayList ArrLst) 
  {
    try
    {
      //BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
      
      //String message;
      //ArrayList<String> ArrLst = new ArrayList<String>();
      
      //while (true) 
      //{
    	//message = fromConsole.readLine();  
    	//if(message.equals("send")) { 
    	System.out.println(ArrLst);
    	client.handleMessageFromClientUI(ArrLst);
    	//}	
    	//ArrLst.add(message);
      //} 
    } 
    catch (Exception ex) 
    {
    	System.out.println ("Unexpected error while reading from console!");
    }
  }
  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  public void display(String message) 
  {
    System.out.println("> " + message);
  }

  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
  public static void main(String[] args) 
  {
    String host = "";
    int port = 0;  //The port number

    try
    {
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "localhost";
    }
    ClientConsole chat= new ClientConsole("DESKTP-EMHP9OV", DEFAULT_PORT);
    ArrayList ArrLst = new ArrayList();
    ArrLst.add("===========1111===========");
    chat.accept(ArrLst);  //Wait for console data
  }
}
//End of ConsoleChat class
