package com.dhenton9000.jboss4x.beans.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Remote;


@Local
public interface BeanTask  {
	public String getInfo(String request);
}
