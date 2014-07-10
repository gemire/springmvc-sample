/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.chat.services;

/**
 *
 * @author dhenton
 */
 
    
 
/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.simp.SimpMessageType;
import java.security.Principal;

/**
 * @author Mark Fisher
 */
public class InboundChannelInterceptor  extends ChannelInterceptorAdapter {

	private final AtomicInteger sendCount = new AtomicInteger();
        private static Logger log = LoggerFactory.getLogger(InboundChannelInterceptor.class);
	private final AtomicInteger receiveCount = new AtomicInteger();


	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		sendCount.incrementAndGet();
                SimpMessageType type = message.getHeaders().get(SimpMessageHeaderAccessor.MESSAGE_TYPE_HEADER,SimpMessageType.class);
                log.debug("preSend "+type.toString());
                Principal p = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER,Principal.class);
                if (p != null)
                {
                    log.debug("preSend "+p.getName());
                }
                else
                {
                    log.debug("principal null");
                }
                
		return message;
	}

	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		receiveCount.incrementAndGet();
                SimpMessageType type = message.getHeaders().get(SimpMessageHeaderAccessor.MESSAGE_TYPE_HEADER,SimpMessageType.class);
                log.debug("postRecieve "+type.toString());
		return message;
	}

	public int getSendCount() {
		return this.sendCount.get();
	}

	public int getReceiveCount() {
		return this.receiveCount.get();
	}

}