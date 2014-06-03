/**
 * Copyright &copy; Sunit Katkar (sunitkatkar@gmail.com) http://sunitkatkar.blogspot.com
 */
package com.dhenton9000.spring.mvc.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.blogspot.sunitkatkar.model.MessageBroadcast;
import com.blogspot.sunitkatkar.model.SimpleMessage;
import com.blogspot.sunitkatkar.util.Util;

/**
 * {@link WebSocketBroadcastController} is a regular Spring Controller as seen
 * in most Spring MVC applications. Its job is to receive {@link SimpleMessage}
 * message objects from the client, extract the <code>payload</code> (or
 * contents) of the message, prepend it with some simple text and finally
 * broadcast (or publish) the message to all clients who have subscribed to the
 * <code>/topic/simplemessages</code> message queue.
 * 
 * 
 * @author <a href="mailto:sunitkatkar@gmail.com">Sunit Katkar</a>
 * @since 1.0
 * @version 1.0.0.1
 */

@Controller
public class WebSocketBroadcastController {

    private static final Logger LOG = LoggerFactory
            .getLogger(WebSocketBroadcastController.class);

    /**
     * Method to handle the requests sent to this controller at
     * <code>/simplemessages</code> <br/>
     * <br/>
     * <b>Explanation:</b> The <code>@MessageMapping</code> annotation ensures
     * that if a message is sent to destination <code>/simplemessages</code>,
     * then the
     * {@link WebSocketBroadcastController#processMessageFromClient(SimpleMessage)}
     * method is called. <br/>
     * <br/>
     * The message payload is bound to the {@link SimpleMessage} object. For
     * simplicity, this method simulates a 3 second delay before sending back
     * the message as a {@link MessageBroadcast} object. The return value is
     * broadcast to all subscribers to
     * <code>/topic/simplemessagesresponse</code> as specified in the
     * <code>@SendTo</code> annotation. <br/>
     * <br/>
     * <b>Note:</b> The 3 second delay demonstrates that after the server
     * receives a message from the client, the client is free to continue any
     * other processing while the server takes its own time to act on the
     * received message.
     * 
     * @param message
     * @param principal
     * @param locale
     * @return
     * @throws Exception
     */
    @MessageMapping("/simplemessages")
    @SendTo("/topic/simplemessagesresponse")
    public MessageBroadcast processMessageFromClient(SimpleMessage message,
            Principal principal) throws Exception {
        // Simulate a delay of 3 seconds
        Thread.sleep(3000);
        LOG.info("Sending server side response '{}' for user: {}", message,
                principal.getName());
        return new MessageBroadcast("Server response: Did you send &lt;b&gt;'"
                + message.getMessage() + "'&lt;/b&gt;? (Server Response at: "
                + Util.getSimpleDate() + ")");
    }

    /**
     * If there are any exceptions thrown by any of the messaging infrastructure
     * then they can be sent to the end user on the <code>/queue/errors</code>
     * destination.
     * 
     * @param exception
     * @return
     */
    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}