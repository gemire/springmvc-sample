package com.dhenton9000.demo.chat;

/* Imports the java.util package class. */
import java.util.*;
/*
   Class AppendUserList – This class stores the name of all the end users connected in the chat session.
   Field:
   sc: Contains the object of the SocketCallback class.
   uL: Stores the user list in an array list.
   Method:
   run() - This method is called by the start() method of Thread class. This method adds the
   user id.		
*/
public class AppendUserList extends Thread
{
   /* Declares the objects of the SocketCallback class. */
   SocketCallback csc=null;
   SocketCallback sc=null;
   /* Declares the object of the ArrayList class. */
   ArrayList uL=null;
   /* Defines default constructor of the AppendUserList class. */
   public AppendUserList(SocketCallback csc,ArrayList UL)
   {
      this.csc=csc;
      this.uL=UL;
      /* Calls the start() method of the Thread class. */
      start();
   }
   /*
run() - This method is called when the thread is started.
      Parameters:   NA
      Return Value: NA
   */   
   public void run()
{
   /*Creates and initializes the object of the Iterator class to get the user id from the user list.*/
   Iterator next=uL.iterator();
   /*Creates a string that contains the user id separator "31".*/
   String s=""+(char)31;
   while(next.hasNext())
   {
      /* Gets the user id from the socket. */
      sc=(SocketCallback)next.next();
      s=s+sc.getUserId()+(char)31;
   }
   /*Adds a user id to the user list.*/
   this.csc.append(s);
   }
}

