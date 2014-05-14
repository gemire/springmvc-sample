/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.rest.controllers;
import java.util.HashMap;
/**
 *
 * @author dhenton
 */
public class RestResult {

	private final HashMap<String,String> messages = new HashMap<>();

	public HashMap<String,String> getMessages() {
		return messages;
	}

	 
	
}