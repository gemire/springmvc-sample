package com.dhenton9000.demo.chat;

/* Imports the java.nio package class. */
import java.nio.*;
import java.nio.channels.*;
/*
Class PRServer_Socket - Uses the sockets to communicate with the chat client.
   Fields:
   soket: Contains the object of the SocketChannel class.
   UserId: Contains the user id.
   Pwd: Contains the password.
   Uinfo: Contains the user information
   broadcast_msg: Contains the broadcasting message.
   Methods:
   isValidUser(): Checks the end user is valid or not.
   ValidUser(): Returns the valid user.
   getChannel(): Returns the socket channel.
   setUserId(): Sets the user id.
   getUserId(): Retrieves the user id.
   setPwd(): Sets the password.
   getPwd(): Retrieves the password.
   setUinfo(): Sets the user information.
   getUinfo(): Retrieves the user information.
   append(): Appends the message.
   append_broad_msg(): Appends the broadcasting messages.
   get_broad_msg(): Retrieves the broadcast messages.
   addString(): Adds message string.
   getString(): Retrieves the messages string.
   getConid(): Returns the connection id.
   doBroadcast(): Broadcasts the message to all user.
   isBroadcast(): Checks message is broadcasted or not.
   setConid(): Sets the connection id.
*/
public class SocketCallback 
{
   /*Declares the object of the SocketChannel class.*/
   private SocketChannel soket=null;
   /*Declares the objects of the String class.*/
   private String str="";
   private String UserId="";
   private String Pwd="";
   private String Uinfo="";
   private int cid=0;
   private boolean isvalid_user=false;
   private boolean userMark=false;
   private boolean msgbroadcast=false;
   String broadcast_msg="";
   /*Defines the default constructor.*/
   public SocketCallback(SocketChannel sc)
   {
      soket=sc;
   }
   /* The isValidUser() implementation. */
   public boolean isValidUser()
   {
      return isvalid_user;
   }   
   /*The ValidUser() implementation.*/
   public void ValidUser(boolean b)
   {
      isvalid_user=b;
   }
   /*The getChannel() implementation.*/
   public SocketChannel getChannel()
   {
      return soket;
   }
   /*The setUserId() implementation.*/
   public void setUserId(String u)
   {
      UserId=u;
   }
   /*The getUserId() implementation.*/
   public String getUserId()
   {
      return UserId;
   }
   /*The setPwd() implementation.*/
   public void setPwd(String u)
   {
      Pwd=u;
   }
   /* The getPwd() implementation. */
   public String getPwd()
   {
      return Pwd;
   }
   /* The setUinfo() implementation. */
   public void setUinfo(String u)
   {
      Uinfo=u;
   }
   /* The getUinfo() implementation. */
   public String getUinfo()
   {
      return Uinfo;
   }
   /* The append() implementation. */
   public void append(String s)
   {
      broadcast_msg=s+broadcast_msg;
   }
   /*The append_broad_msg() implementation.*/
   public void append_broad_msg(String msg)
   {
      if (msg.length()>0)
   { 
      broadcast_msg+=msg;
   }
   }
   /*The get_broad_msg() implementation.*/
   public String get_broad_msg()
   {
      return broadcast_msg;
   }
   /*The addString() implementation.*/
   public void addString(String s)
   {
      str=s;
   }
   /*The getString() implementation.*/
   public String getString()
   {
      String str1=new String(str);
      str="";
      return str1;
   }
   /*The getConid() implementation.*/
   public int getConid()
   {
      return cid;
   }
   /*The doBroadcast() implementation.*/
   public void doBroadcast(boolean chk)
   {
      msgbroadcast=chk;
   }
   /*The doBroadcast() implementation.*/
   public void doBroadcast()
   {
      broadcast_msg="";
   }
   /* The isBroadcast() implementation. */
   public boolean isBroadcast()
   {         
      return msgbroadcast;
   }
   /* The setConid() implementation. */
   public void setConid(int id)
   {
      cid=id;
   }


}
