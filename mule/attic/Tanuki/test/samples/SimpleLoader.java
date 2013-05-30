package samples;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SimpleLoader {
	private static Logger log = LogManager.getLogger(SimpleLoader.class);

	Context jndiContext = null;
	QueueConnectionFactory queueConnectionFactory = null;
	QueueConnection queueConnection = null;
	Queue queue = null;
	final int NUM_MSGS = 20;

	public boolean doSetup() {
		boolean okay = false;
		try {
			jndiContext = new InitialContext();
		} catch (NamingException e) {
			log
					.error("Could not create JNDI API " + "context: "
							+ e.toString());

		}

		/*
		 * Look up connection factory and queue. If either does not exist, exit.
		 */
		try {
			queueConnectionFactory = (QueueConnectionFactory) jndiContext
					.lookup("QueueConnectionFactory");
			if (queueConnectionFactory == null)
				log.error("null factory");
			queue = (Queue) jndiContext.lookup("manny");
			if (queue == null)
				log.error("null factory");
			log.debug("finished config");
			okay = true;

		} catch (NamingException e) {
			log.error("JNDI API lookup failed: " + e.toString());

		}
		return okay;
	}
	
	/**
	 * manually say OK I'm ready to take the message on the client
	 */
	public void doReceiveAck()
	{
		
		if (doSetup()) {
			 try {
		            queueConnection = 
		                queueConnectionFactory.createQueueConnection();
		            QueueSession queueSession = queueConnection.createQueueSession(false, 
					    Session.CLIENT_ACKNOWLEDGE);
		            QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		            queueConnection.start();
		            String info = null;
		            while (true) {
		                Message m = queueReceiver.receive(1);
		                if (m != null) {
		                    if (m instanceof TextMessage) {
		                        TextMessage message = (TextMessage) m;
		                        info = message.getText();
		                        
		                    
		                        if (info.indexOf("12")> -1)
		                        {
		                        	log.debug("Skipping message:==> " +
				                            message.getText());
		                        }
		                        else
		                        {
		                        	log.debug("Reading message:==> " +
				                            message.getText());
		                        	message.acknowledge();
		                        }
		                    
		                    
		                    
		                    } else {
		                        break;
		                    }
		                }
		            }
		        } catch (JMSException e) {
		            log.error("Listen Exception occurred: " + 
		                e.toString());
		        } finally {
		        	doCleanup();
		        }

			
		}
	}
	
	/**
	 * use auto acknowledge which automatically has the client say OK
	 */
	public void doReceiveAuto()
	{
		
		if (doSetup()) {
			 try {
		            queueConnection = 
		                queueConnectionFactory.createQueueConnection();
		            QueueSession queueSession = queueConnection.createQueueSession(false, 
					    Session.AUTO_ACKNOWLEDGE);
		            QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		            queueConnection.start();
		            while (true) {
		                Message m = queueReceiver.receive(1);
		                if (m != null) {
		                    if (m instanceof TextMessage) {
		                        TextMessage message = (TextMessage) m;
		                        log.debug("Reading message:==> " +
		                            message.getText());
		                    } else {
		                        break;
		                    }
		                }
		            }
		        } catch (JMSException e) {
		            log.error("Listen Exception occurred: " + 
		                e.toString());
		        } finally {
		        	doCleanup();
		        }

			
		}
	}

	public void doSend() {

		QueueSession queueSession = null;
		QueueSender queueSender = null;
		TextMessage message = null;

		if (doSetup()) {

			try {
				queueConnection = queueConnectionFactory
						.createQueueConnection();
				queueSession = queueConnection.createQueueSession(false,
						Session.AUTO_ACKNOWLEDGE);
				queueSender = queueSession.createSender(queue);
				message = queueSession.createTextMessage();
				for (int i = 0; i < NUM_MSGS; i++) {
					message.setText("This is message " + (i + 1));
					System.out.println("Sending message: " + message.getText());
					queueSender.send(message);
				}

				/*
				 * Send a non-text control message indicating end of messages.
				 */
				queueSender.send(queueSession.createMessage());
			} catch (JMSException e) {
				log.error("JMS Send Exception occurred: " + e.toString());
			} finally {
				doCleanup();
			}

		}
	}

	private void doCleanup() {
		if (queueConnection != null) {
			try {
				queueConnection.close();
			} catch (JMSException e) {
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleLoader loader = new SimpleLoader();
		try {
			loader.doSend();
			loader.doReceiveAck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
	}

}
