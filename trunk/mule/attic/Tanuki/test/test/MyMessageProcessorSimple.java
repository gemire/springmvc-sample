package test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;



public class MyMessageProcessorSimple implements MessageListener
{
	JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate()
	{
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate)
	{
		this.jmsTemplate = jmsTemplate;
	}

	public void onMessage(Message msg)
	{
		try
		{
			System.out.println("##msg=" + ((TextMessage) msg).getText());

			throw new RuntimeException("Failed now - "+((TextMessage) msg).getText());
		} catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}