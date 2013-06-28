package com.dhenton9000.demo.chat;

/*Imports the java.util package class.*/
import java.util.*;
/*
   Class Msgbroadcast - Broadcasts the messages to all the end users connected in a chat session.   Field:
   storer - Stores the user list.
   sc - Stores the object of the SocketCallback class.
   next - Contains the Iterator object.
   msg - Contains the message.
   userId - contains the name of the end user.
*/
public class Msgbroadcast extends Thread
{
   /*Declares the object of the ArrayList class.*/
   ArrayList storer = null;
   /*Declares the object of the SocketCallback class.*/
   SocketCallback sc = null;
   /*Declares the object of the Iterator class.*/
   Iterator next = null;
   /* Declares the object of the String class.*/
   String msg = "";
   String userId = null;
   /*Defines the default constructor of the Msgbroadcast class.*/
   Msgbroadcast(ArrayList store,String msg,String userId)
   {
      storer = store;
      this.msg = msg;
      this.userId = userId;
      /*Calls the start() method of the Thread class. */
      start();
   }
   /*
      run() - This method is called when the thread is started.
         Parameters:   NA
         Return Value: NA
   */   
   public void run()
   {
      /* Initializes the object of the Iterator class to get the user id from the user list. */
      next=storer.iterator();
      while(next.hasNext())
      {
         /* Gets the user id from the socket. */
         sc=(SocketCallback)next.next();
         /* Broadcasts the messages to all end users. */
         sc.append_broad_msg(userId + ":" + msg);
      }
   }
}

