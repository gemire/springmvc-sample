package com.dhenton9000.demo.chat;

/*Imports the java.net package class.*/
import java.net.*;
/*Imports the java.net package class.*/
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
/*Imports the java.util package class.*/
import java.util.*;
/*Imports the java.io package class.*/
import java.io.*;
/*
Class UAServer_Socket - Creates the socket, registers and maps the socket to broadcast the _
message to all the end users connected in a chat session.
   Fields:
      Port - Contains the port number.
      srvr_sckt_chnel - Creates the server socket channel.
      sckt_manager - Manages the various sockets.
      selkey - Selects the appropriate socket.
      tdata - Stores the array of bytes.
      broadcastMessage - Stores the messages.
   Method:
      init_socket() - Initializes the private messaging socket.
      register_server() - Registers the server.
      accept_connection() - Accepts the connections from the server.
      read_Message() - Reads the message from the server socket.
      closeRemoteChannel() - Closes all the remote channels.
      write_Message() - Writes the messages to the server socket.
      got_connection() – Retrieves the connection.
*/
public class UAServer_Socket implements Runnable
{
   /*Declares the port for broadcasting.*/
   int port=9999;
   /*Declares the object of the ServerSocketChannel class.*/
   ServerSocketChannel srvr_sckt_chnel=null;
   /*Declares the object of the Selector class.*/
   Selector sckt_manager=null;
   /*Declares the object of the Iterator class.*/
   Iterator searcher=null;
   /*Declares the object of the SelectionKey class.*/
   SelectionKey selkey=null;
   /*Declares the objects of the ArrayList class.*/
   ArrayList broadcastMessage=new ArrayList();
   /*Declares the object of the ByteBuffer class and allocate the size to the byte buffer.*/   
   ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
   int buflen=0;
   byte[] tdata=null;
   int conId=0;
   int kichek =0;
   /* 
   Defines the constructor that provides the port number as input. 
   */
   public UAServer_Socket(int port)
   {
      this.port=port;
   }
   /* Defines the constructor that provides the port number and user list as input. */
   public UAServer_Socket(int port, ArrayList conlist)
   {
      this.port=port;
      broadcastMessage=conlist;
   }
   /* Defines the constructor that provides the user list as input. */
   public UAServer_Socket(ArrayList conlist)
   {
      broadcastMessage=conlist;
   }
   /*
   init_socket() - This method initializes the chat server.
      Parameter: NA
      Return Value: NA
   */
   public void init_socket() throws Exception
   {
      /*Opens the selector*/
      sckt_manager=SelectorProvider.provider().openSelector();
      /*Opens the server socket channel.*/
      srvr_sckt_chnel=ServerSocketChannel.open();
      /*Configures the server as NON Blocking.*/
      srvr_sckt_chnel.configureBlocking(false);
      /*Creates and initialize the object of the InetSocketAddress class.*/
      InetSocketAddress fulnetaddr=new InetSocketAddress(port);
      /*Binds the server socket.*/
      srvr_sckt_chnel.socket().bind(fulnetaddr);
      /*Calls the register()method.*/
      register_server(srvr_sckt_chnel,SelectionKey.OP_ACCEPT);
   }
   /*
      register_server() - This method registers the chat server.
      Parameter: 
          Ssc: Represents the object of the ServerSocketChannel class.
          selectionkey_ops: Integer type that determines the selection option.
       Return Value: NA
   */
   public void register_server(ServerSocketChannel ssc,int selectionkey_ops)throws Exception
   {
      ssc.register(sckt_manager,selectionkey_ops);
   }
   /*
   run() - This method calls the methods to initialize the socket and accept the connection of _
   the sockets.
      Parameters: NA
      Return Value: NA
   */   
   public void run()
   {
      try
      {
         /*Calls the initialization method.*/
         init_socket();
         /*Calls the method to accept the connection.*/
         accept_connection();
      }
      catch(Exception ej)
      {
         ej.printStackTrace();
      }
   }
   /*
   accept_connection() - This method accepts the connection from the server.
   Parameter: NA         
   Return Value: NA
   */
   public void accept_connection()throws Exception
   {
      while (true)
         {
            /*Calls the select() method of the Selector class.*/
            kichek=sckt_manager.select();
            if(kichek>=0)
            {
               /*
               Initializes the object of the Iterator class by calling the selectedKeys() methodof the Selector class. 
               */
               searcher=sckt_manager.selectedKeys().iterator();
               while(searcher.hasNext())
               {
                  /*Gets the next element.*/
                  selkey=(SelectionKey)searcher.next();
                  /*Removes the item from the searcher.*/
                  searcher.remove();
                  /*When the message provider gets new connection from user, this section is _
                  executed.*/   
                  if(selkey.isAcceptable())
                  {
                     /*Creates and initializes the object of the ServerSocketChannel class to _
                     get the channel withthe help of the channel() method.*/
                     ServerSocketChannel server=(ServerSocketChannel)selkey.channel();
                     /* Calls the got_connection() method.*/
                     got_connection(server);
                     System.out.println("connection establish");
               }
/* When the selector provider gets the stream for reading by the server from end user, this _
section is executed.*/
else if(selkey.isReadable())
            {
               /*Calls the read_Message() method.*/
               read_Message((SocketCallback)selkey.attachment());
               }
               
/*When the selector Provider gets the stream for writing to user, this section is executed.*/
else if(selkey.isWritable())
               {
                  /*Creates the object of the SocketCallback class and call the attachment() _
                  method of the SelectionKey class.*/
                  SocketCallback  Vsc=(SocketCallback)selkey.attachment();
                  String m_essage="";
                  if (Vsc.getString().length()>0)
                  m_essage =Vsc.getString();      
                  if(Vsc.get_broad_msg().length()>0)
                  m_essage +=Vsc.get_broad_msg();
                  /* Calls the write_Message(). */            
                  write_Message(Vsc,m_essage);
                  }
                  }
               }
            else
            break;
                     }
               }
   /*
   read_Message() - This method reads the messages from the server socket.
      Parameter: 
       sc: Represents the object of the SocketCallback class.         
       Return Value: 
       String: Returns a string value.
   */
   public String read_Message(SocketCallback sc) 
   {
      try
      {
         if (sc.isValidUser())
         {
               /* Clears the buffer. */
            buffer.clear();
/*Reads the bytes from the channel. */
int nbyte=sc.getChannel().read(buffer);
            if(nbyte==-1)
            {
               /*Closes the channel. */
               closeRemoteChannel(sc);
               sc.getChannel().close();
               return "";
            }
            if (nbyte>0)
            {
               /*Flips the buffer.*/
               buffer.flip();
               /*Initializes the object of the Byte class.*/
               tdata=new byte[nbyte];
               /*Retrieves the data from the buffer.*/         
               buffer.get(tdata,0,nbyte);
               /*Initializes the object of the Inner_checker class.*/
               String s=new String(tdata);
               if(tdata[0]==31)
               {   
                  /*Initializes the object of the AppendUserList class.*/
                  new AppendUserList(sc,broadcastMessage); 
                  return "";
               }
               else
               {
                  if (s.length()>0)
                  {
                  sc.addString(s);
                  /*Initializes the object of the Msgbroadcast class.*/
                  new Msgbroadcast(broadcastMessage,s,sc.getUserId());
                  return s;
                  }
               }
            }
         }
         else 
         {
            /*Clears the buffer.*/
            buffer.clear();
            
            /*Reads the bytes from the channel.*/
            int
            nbyte=sc.getChannel().read(buffer);
            if(nbyte==-1)
            {
               /*Closes the channel.*/
               closeRemoteChannel(sc);
               sc.getChannel().close();
               return "";
            }
            if (nbyte>0)
              {
               /*Flips the buffer.*/
               buffer.flip();
               /*Initializes the object of the Byte class.*/
                              tdata=new byte[nbyte];
               /*Retrieves the data from the buffer.*/
               buffer.get(tdata,0,nbyte);
               /*Initializes the object of the Inner_checker class.*/
               new UAinnerChecker(sc,tdata,nbyte);
                           }
                        }
            }
      catch(IOException ex)
      {
         try
         {
            /*Calls the closeRemoteChannel() method.*/
                        closeRemoteChannel(sc);
                        /* Closes the channel. */
                        sc.getChannel().close();
                     }
                     catch(IOException ec)
                     {
                        ec.printStackTrace();
                     }
                  }
                  /*Returns a null string.*/
      return "";
      }
      /*
         closeRemoteChannel() - This method close the remote channel.
            Parameter: 
            sCb: Represents the object of the SocketCallback class.         
            Return Value: NA         
   */
      public void closeRemoteChannel(SocketCallback sCb)
   {
      int i = broadcastMessage.indexOf(sCb);
      if (i >= 0) 
      {
         /*Removes the broadcast message from the list.*/
         broadcastMessage.remove(i);
      }
   }
   /*
      write_Message() - This method writes the messages to the server socket.
         Parameter: 
         sc: Represents the object of the SocketCallback class.         
         msg: Stores the message.
         Return Value: NA         
   */
   public void write_Message(SocketCallback sc,String msg)throws Exception
   {
      if (msg.length()>0)
      {
         /*Calls the doBroadcast() method.*/
         sc.doBroadcast();
         /*Creates the object of the ByteBuffer class. Next, wraps the bytes that are retrieved
         from the message.*/
         ByteBuffer b=ByteBuffer.wrap(msg.getBytes());
         /*Writes the byte buffer to the server socket.*/
         sc.getChannel().write(b);
         }
      }
   /*
   got_connection() - This method gets the connection from the server.
      Parameter: 
      server: Represents the object of the ServerSocketChannel class.
      Return Value: NA         
   */
   private void got_connection(ServerSocketChannel servr)throws Exception
   {
      /*Initializes the object of the SocketChannel class to accept the connection.*/
      SocketChannel sc=servr.accept();
      /*Sets the server to Non Blocking server.*/
      sc.configureBlocking(false);
      /*Registers the server socket with the selector.*/
      SelectionKey skey=sc.register(sckt_manager,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
      /*Creates the object of the SocketCallback class.*/
      SocketCallback callbk=new SocketCallback(sc);
      skey.attach(callbk);
      }
   /*
      finalize() - This method is invoked when message is read or sent.
      Parameter: NA   
      Return Value: NA         
   */
   public void finalize() throws IOException
   {
      /*Closes the server socket channel.*/
               srvr_sckt_chnel.close();
               /* Closes the selector. */
               sckt_manager.close();
   }

   /* 
   Inner Class: UAinnerChecker - This class checks the user validity.
      Methods: 
      run(): Runs the started threads.
      Chk_Validity(): Checks the user validity.
      Chk_Valid_User(): Checks user validation.
   */
   class UAinnerChecker extends Thread               
   {
      /* eclares the objects of the SocketCallback class.*/
      SocketCallback u=null;
      byte[] b=null;
      int len=0;
      /*Defines the constructor that takes the SocketCallback class object and integer type
      value as parameters.*/
      UAinnerChecker(SocketCallback call,byte[] b,int len)
      {
         this.u=call;
         this.b=b;
         this.len=len;
         start();
      }
      /*
         run() - This method is called when the thread is started to call the thread methods. 
            Parameters:   NA
            Return Value: NA
      */   
      public void run()
      {
         /*Calls the Chk_Validity() method.*/
         Chk_Validity();
      }
      /*
      Chk_Validity() - This method check the user validity.  
         Parameter: NA            
         Return Value: NA         
      */
      private void Chk_Validity()
      {
         /*Declares the objects of the String class.*/
         String u_id="";
         String pwd="";
         String info="";
         /* Declares the FLAGS. */
         boolean id_flag=true; 
         boolean pwd_flag=true;
         try
         {
            for (int x=0;x<len;x++ )
            {
               if(id_flag)
               {
                  /*Checks the user name separator "28" in the string.*/
                  if (b[x]==28)
                  {
                  id_flag=false;
                  }
                  else
                  u_id+=(char)b[x];
               }
               else if(pwd_flag)
               {
                  /*Checks the password separator "29" in the string.*/
                  if (b[x]==29)
                  {
                  pwd_flag=false;
                  }
                  else
                  pwd+=(char)b[x];
              }
              else
              info+=(char)b[x];
            }
/*Checks the chat user is valid or not.*/
if(Chk_Valid_User(u_id, pwd))
{
   /*Calls the setUserId() method of the SocketCallback class.*/
   u.setUserId(u_id);
   /*Calls the setPwd() method of the SocketCallback class.*/
   u.setPwd(pwd);
   /*Calls the setUinfo() method of the SocketCallback class.*/
   u.setUinfo(info);
   /*Calls the ValidUser() method of the SocketCallback class.*/
   u.ValidUser(true);
   /*Increments the counter by one. */
   conId++;
   /*Calls the setConid() method of the SocketCallback class.*/
   u.setConid(conId);
   broadcastMessage.add(u);
}
else
{
   /*Closes the channel.*/
   u.getChannel().close();
}
}
catch(Exception e3)
         {
            e3.printStackTrace();
         }          
      }
      /*
         Chk_Valid_User() - This method checks the user is valid or not.
            Parameter: 
            Uid: Stores the user name.
            pass: Stores the password.
            Return Value: NA         
      */
public boolean Chk_Valid_User(String Uid,String pass)
      {
           return true;
        }
   } 
}

