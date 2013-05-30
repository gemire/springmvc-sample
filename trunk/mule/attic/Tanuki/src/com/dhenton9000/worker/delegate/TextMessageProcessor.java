package com.dhenton9000.worker.delegate;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;





public class TextMessageProcessor  {
	private static Logger log = LogManager.getLogger(TextMessageProcessor.class);
    private JmsTemplate completedQueueTemplate = null;
    private String idString = null;
    private boolean poison = false;
	public void receive(String i) {
		 
		
		  long delay = 0L;
		  double d = Math.random() * 4000.0  ;
		  
		  delay = 1500 +  (long) d;
		   
		  String z = new String(i.trim().toUpperCase());
		  log.debug("$"+getIdString()+"$ delay "+delay+" -->  text message is '"+i+"' ");
	
		  try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			
		}

		  
		  
		  //		  if (z.equals("DEAD"))
//		  {
//			  throw new IllegalArgumentException("Dead is read");
//		  }
		  
		  if (poison)
		  {
			  
			  if (z.indexOf("DEAD") > -1)

			  {
				 // log.debug("throwing arugment problem");
				 // throw new IllegalArgumentException("Dead found");
			  }
			  
			  
			  
		  }// end if poison
		 
			
		}

	public JmsTemplate getCompletedQueueTemplate() {
		return completedQueueTemplate;
	}

	public void setCompletedQueueTemplate(JmsTemplate completedQueueTemplate) {
		this.completedQueueTemplate = completedQueueTemplate;
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public boolean isPoison() {
		return poison;
	}

	public void setPoison(boolean poison) {
		this.poison = poison;
	}
 
	
	
}
