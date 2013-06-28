package com.dhenton9000.demo.chat;


import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.util.*;

import java.io.*;
/*
class ChatServer - Initializes all the chat server classes. This is the main class of the chat _
server. 
   Field:
   SendAllPort: Stores the default port number.
   SendPrivatePort: Stores the default port number.
   UserList: Stores the list of users.
   Method:
   start_server(): Creates the objects of socket classes and starts the thread to run _
   the server.
   main(): Creates the object of the ChatServer class and call the Start_Server() _
   method.
*/
public class ChatServer
{
   /*Declares the port numbers.*/
   private int SendAllPort=9999;
   private int SendPrivatePort=8888;
   /*Creates and initializes the object of the ArrayList class.*/
   ArrayList UserList=new ArrayList();
   /*Defines the default constructor.*/   
   public ChatServer(){}
   /*
   start_server() - This method is called to start the chat server. 
   Parameters:   NA
   Return Value: NA
   http://book.javanb.com/sillsoft-Press-Java-instantcode-developing-applications-using-java-nio/LiB0010.html
   
   */
   public void start_server()
   {
      /*Creates the object of the UAServer_Socket class.*/
      UAServer_Socket ua=new UAServer_Socket(SendAllPort,UserList);
      /*Creates the object of the PRServer_Socket class.*/
      PRServer_Socket p=new PRServer_Socket(SendPrivatePort,UserList);
      /*Initializes and starts a new thread to create the socket for broadcasting.*/
      new Thread(ua).start();
      /*Initializes and starts a new thread to create the socket for private messaging.*/
      new Thread(p).start();
      System.out.println("Server is started. Now waiting for client requests...");
   }
   /*
      main() - This method creates the main window of the user interface and displays it.
      Parameters:
      args[] - Contains any command line arguments passed.
      Return Value: NA
   */
   public static void main(String[] args) 
   {
      /*Creates and initializes the objects of the ChatServer class.*/
      ChatServer cs=new ChatServer();
      /* Calls the Start_Server() method. */
      cs.start_server();
   }
}

