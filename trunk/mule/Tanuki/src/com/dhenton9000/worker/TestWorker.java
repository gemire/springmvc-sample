package com.dhenton9000.worker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;


public class TestWorker {

	private static Logger log = LogManager.getLogger(TestWorker.class);

	private JmsTemplate jmsWorkQueueTemplate = null;

	public JmsTemplate getJmsWorkQueueTemplate() {
		return jmsWorkQueueTemplate;
	}

	public void setJmsWorkQueueTemplate(JmsTemplate jmsWorkQueueTemplate) {
		this.jmsWorkQueueTemplate = jmsWorkQueueTemplate;
	}
	
	
	
}
