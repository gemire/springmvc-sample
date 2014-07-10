package com.dhenton9000.spring.events;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5743058377815147529L;
	
	private String message;

	public MessageEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageEvent [message=").append(message).append("]");
		return builder.toString();
	}

}
