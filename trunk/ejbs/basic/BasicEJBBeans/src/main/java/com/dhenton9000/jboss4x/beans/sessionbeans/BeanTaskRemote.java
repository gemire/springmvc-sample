package com.dhenton9000.jboss4x.beans.sessionbeans;

import javax.ejb.Remote;

@Remote
public interface BeanTaskRemote   {
	public String getInfo(String request);
}
