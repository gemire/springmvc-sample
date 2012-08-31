/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.mule.jmx;


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;


@ManagedResource(objectName = "com.dhenton9000.mule.jmx.log4j:name=Mule Logging", description = "Mule Logging", log = true, logFile = "/home/dhenton/logs/jmx.log", currencyTimeLimit = 15, persistPolicy = "OnUpdate", persistPeriod = 200, persistLocation = "logging", persistName = "logging")
public class MuleJMXModifier {
	@ManagedOperation(description = "Set the logging level for a category")
	@ManagedOperationParameters( { @ManagedOperationParameter(name = "category", description = "Logger category"),
			@ManagedOperationParameter(name = "level", description = "Logging level") })
	public void setLoggerLevel(String category, String level) {
		LogManager.getLogger(category).setLevel(Level.toLevel(level));
	}

	@ManagedOperation(description = "Get the logging level for a category")
	@ManagedOperationParameters( { @ManagedOperationParameter(name = "category", description = "Logger category") })
	public String getLoggerLevel(String category) {
		return LogManager.getLogger(category).getLevel().toString();
	}
}