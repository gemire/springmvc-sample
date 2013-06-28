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
Class PRServer_Socket - Creates the socket, registers and maps the socket to send private _
messages to the specified end user.
      Fields:
      port: Contains the port number.
      srvr_sckt_chnel: Creates the server socket channel.
      sckt_manager: Manages the various sockets.
      selkey: Selects the appropriate socket.
      tdata: Stores the array of the bytes.
      userName: Stores the name of the private message user.
      privateMessage - Stores the messages.
      Methods:
      init_socket(): Initializes the private messaging socket.
      register_server(): Registers the server.
      run(): Runs the started threads.
            accept_connection() - Accepts the connections from the server.
            read_Message() - Reads the message from the server socket.
            closeRemoteChannel() - Closes all the remote channels.
            write_Message() - Writes the messages to the server socket.
            got_connection() - Retrieves the connection.
            finalize() - Finalizes the server connection.
*/
public class PRServer_Socket implements Runnable
{
   /*Declares the port for private messaging.*/
   int port=8888;
   /*Declares the object of the ServerSocketChannel class.*/
   ServerSocketChannel srvr_sckt_chnel=null;
   /*Declares the object of the Selector class.*/
   Selector sckt_manager=null;
   /*Declares the object of the Iterator class.*/
   Iterator searcher=null;
   /*Declares the object of the SelectionKey class.*/
   SelectionKey selkey=null;
   /*Declares the object of the ByteBuffer class and allocate the size to byte buffer.*/   
   ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
   /*Declares the objects of the ArrayList class.*/
   ArrayList userName=new ArrayList();
   ArrayList privateMessage = new ArrayList();
   int conId=0;
   int buflen=0;
   byte[] tdata=null;
   int kichek =0;
   /* Defines the constructor that provides the port number as input. */
   public PRServer_Socket(int port)
   {
      this.port=port;
   }
   /*Defines the constructor that provides the port number and user list as input.*/
   public PRServer_Socket(int port, ArrayList conlist)
   {
      this.port=port;
      userName=conlist;
   }
   /*Defines the constructor that provides the user list as input.*/
   public PRServer_Socket(ArrayList conlist)
   {
      userName=conlist;
   }
   /*
   init_socket() - This method initializes the chat server.
   Parameter: NA
   Return Value: NA
   */
   public void init_socket() throws Exception
   {
      /*Opens the selector.*/   
      sckt_manager=SelectorProvider.provider().openSelector();
      /*Opens the server socket channel.*/
      srvr_sckt_chnel=ServerSocketChannel.open();
      /* Configures the server as NON Blocking.*/
      srvr_sckt_chnel.configureBlocking(false);
      /*Creates and initializes the object of the InetSocketAddress class.*/
      InetSocketAddress fulnetaddr=new InetSocketAddress(port);
      /*Binds the server socket.*/
      srvr_sckt_chnel.socket().bind(fulnetaddr);
      /*Calls the register()method.*/
      register_server(srvr_sckt_chnel,SelectionKey.OP_ACCEPT);
   }
   /*
      register_server() - This method register the chat server.
         Parameter: 
         ssc: Represents the object of the ServerSocketChannel class.
         selectionkey_ops: Integer type that determines the selection option.
         Return Value: NA
   */
public void register_server(ServerSocketChannel ssc, int selectionkey_ops)throws Exception
   {
      /*Calls the register() method of the ServerSocketChannel class*/
      ssc.register(sckt_manager,selectionkey_ops);
   }
   /*
      run() - This method is called when the thread is started.
         Parameters:   NA
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
         kichek = sckt_manager.select();
         if(kichek >= 0)
         {
            /*Initializes the object of the Iterator class by calling the selectedKeys() method
            of the Selector class.*/
            searcher = sckt_manager.selectedKeys().iterator();
            while(searcher.hasNext())
            {
               /*Gets the next element.*/
               selkey = (SelectionKey)searcher.next();
               /*Removes the item from the searcher.*/
               searcher.remove();
               /*When the message provider gets new connection from the end user, this section
               is executed.*/
               if(selkey.isAcceptable())
               {
                  /*Creates and initializes the object of the ServerSocketChannel class to get _
                  the channel using the channel() method.*/
                  ServerSocketChannel server=(ServerSocketChannel)selkey.channel();
                  /*Calls the got_connection() method.*/
                  got_connection(server);
                  System.out.println("connection establish");
               }
/*When the selector provider gets the stream for reading by the server from the end user, this _
section is executed.*/
else if(selkey.isReadable())
               {
                  /*Calls the read_Message() method*/
                  read_Message((SocketCallback)selkey.attachment());
               }
/* When selector Provider gets stream for writing to the end user, then this section is executed. */
else if(selkey.isWritable())
               {
                  /* Creates the object of the SocketCallback class and calls the attachment() _
                  method of the SelectionKey class. */
                  SocketCallback  vsc =(SocketCallback)selkey.attachment();
                  String m_essage="";
                  if (vsc.getString().length()>0)
                  m_essage =vsc.getString();
                  if(vsc.get_broad_msg().length()>0)
                  m_essage +=vsc.get_broad_msg();
                  /* Calls the write_Message(). */
                  write_Message(vsc,m_essage);
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
sc: Represents the object of the SocketCallback class         
      Return Value: 
      String: Returns a string value.
   */
   public String read_Message(SocketCallback sc) 
   {
      try
      {
         /*Clears the buffer.*/
         buffer.clear();
/*Reads the bytes from the channel.*/
int nbyte=sc.getChannel().read(buffer);
         if(nbyte==-1)
         {
            /*Closes the channel.*/
            sc.getChannel().close();
            return "";
         }
         if (nbyte>0)
         {
            /* Flips the buffer. */
            buffer.flip();
            /*Initializes the object of the Byte class.*/
            tdata=new byte[nbyte];
            /*Retrieves the data from the buffer. */
            buffer.get(tdata,0,nbyte);
            /*Initializes the object of the Inner_checker class.*/
            new Inner_checker(sc,tdata,tdata.length);
         }
       }
      catch(IOException ex)
      {
         try
         {
            /*Calls the closeRemoteChannel() method.*/
            closeRemoteChannel(sc);
            /*Closes the channel.*/
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
      closeRemoteChannel() - This method close the remote channel 
         Parameter: 
      sCb: Represents the object of the SocketCallback class.         
         Return Value: NA         
   */
      public void closeRemoteChannel(SocketCallback sCb)
         {
            int i = userName.indexOf(sCb);
            if (i >= 0) 
            {
            /*Removes the user name from the list.*/
                     userName.remove(i);
                  }
                  int j = privateMessage.indexOf(sCb);
                  if (j >= 0) 
                  {   
            /*Removes the private message from the user list.*/
                     privateMessage.remove(j);
      }
   }
   /*
write_Message() - This method write the messages to the server socket
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
         from the message. */
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
      /* Registers the server socket with the selector.*/
      SelectionKey skey=sc.register(sckt_manager,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
      /*Creates the object of the SocketCallback class.*/
      SocketCallback callbk=new SocketCallback(sc);
      privateMessage.add(callbk);
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
      /*Closes the selector.*/
      sckt_manager.close();
   }
   /* 
      Inner Class: Inner_checker - This class checks the end user validity.
            Methods: 
            run(): Runs the started threads.
            readName(): Reads the user name.
      storeMessage_on_Database(): Stores the messages.
   */
   class Inner_checker extends Thread                  
   {
      /*Declares the objects of the SocketCallback class.*/
      SocketCallback to_m=null;
      SocketCallback from=null;
      byte ib[]=null;
      int blen=0;
      /*Defines the constructor that takes the SocketCallback class object and integer type _
      value as parameters.*/
      public Inner_checker(SocketCallback isc,byte[] msgbyte,int mlen)
            {
               from=isc;
               ib=msgbyte;
               blen=mlen;
               /*Calls the start() method.*/
               start();
            }
      /*
         run() - This method is called when the thread is started.
            Parameters:   NA
            Return Value: NA
      */   
      public void run()
      {
         boolean V_U_chk=false;
         /*Initializes the object of the Iterator class that gets the user name.*/
         Iterator chkval=userName.iterator();
         /*Gets the user id.*/
         String fromName = "" + from.getUserId();
         String[] s=null;
         if(fromName.length()<1)
         {
            /*Calls the readName() method.*/
            s=readName(ib,blen,1);
            return;
         }
         else
         {
            /*Calls the readName() method.*/
            s=readName(ib,blen,0);
            /*Gets the user id.*/
            fromName=from.getUserId();
         }
           while(chkval.hasNext())
         {
            to_m=(SocketCallback)chkval.next();
            if(fromName.equals(to_m.getUserId()))
            {
                  V_U_chk=true;
                  break;
            }
         }
            if(!V_U_chk)
         {
            try
            {
            from.getChannel().close();
            int iobj = privateMessage.indexOf(from);
            if (iobj >= 0) 
               {
                  /*Removes private message from the privateMessage array list.*/
                  privateMessage.remove(iobj);
               }
            return;
            }
            catch(Exception ec)
            { 
               ec.printStackTrace();
            }
         }
/*Initiates the object of the Iterator class to iterate the private message.*/
Iterator n=privateMessage.iterator();
         SocketCallback msgTo=null;
         while(n.hasNext())
         {
            msgTo=(SocketCallback)n.next();
            if(msgTo.getUserId().equals(s[0]))
            {
               /*Calls the append_broad_msg() message of the SocketCallback class.*/
               msgTo.append_broad_msg(from.getUserId()+ ":"+s[1]);
               /*Calls the storeMessage_on_Database() method.*/
               storeMessage_on_Database(s[1],s[0],fromName);
               break;
            }
         }
      }
      /*
         readName() - This method reads the name of the user. 
            Parameter: 
            b: Represents a byte array.
            len: Contains the length.
            chk: Represents the chk integer.
            Return Value: NA         
      */
private String[] readName(byte[] b,int len,int chk)
      {
         String tmp="";
         int sindex=0;
         byte t[]=null;
         String tmpStr[]=new String[2];
         String usrNAME="";
         for(int x=0;x<len;x++)
         {
            /*Checks for read name separator.*/
            if(b[x]==3)
            {      
               sindex=x;
               break;
            }
            else 
            tmp+=(char)b[x];   
         }
               if(chk==1)
         {
            for(int x=sindex+1;x<len;x++)
            {
               if(b[x]==3)
               {      
                  sindex=x;
                  break;
               }
               else 
/*Reads from the end user.*/
               usrNAME+=(char)b[x];
            }
            /*Sets user id.*/
            from.setUserId(usrNAME);
         }
            int tmpval=len-sindex;
            t=new byte[tmpval];
         /*Copies the array.*/
         System.arraycopy(b,sindex+1,t,0,tmpval-1);
         tmpStr[0]=tmp;
         /*Creates and initializes the object of the String class.*/
         tmpStr[1]=new String(t);
         /*Returns the user name array string.*/
         return tmpStr;
      };
      /*
         storeMessage_on_Database() - This method stores the messages on database.
            Parameter:
            u_msg: Contains the message.
            to_clientID: Contains the sender user name.
            from_id: Contains the receiver user name.
            Return Value: NA
      */
public void storeMessage_on_Database(String u_msg,String to_clientID,String from_id)
      {
         /*Inserts code here to implement this method.*/ 
      };
   
   };


}
