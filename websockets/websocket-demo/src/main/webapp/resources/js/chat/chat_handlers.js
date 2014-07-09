/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

chat_handlers = {
    
    usersList: $('#usersList'),
    onError: function(evt)
    {
        console.log("error event ", evt);
    },
    onClose: function(evt)
    {
        
        $("#disconnectButton").prop('disabled', !chat.isConnected);
        $("#connectButton").prop('disabled', chat.isConnected);
        $("#sendMessageButton").prop('disabled', !chat.isConnected); 
        console.log("onClose");
        chat_handlers.usersList.empty();
    },
    
    onCloseRequested: function(evt)
    {
        
        $("#disconnectButton").prop('disabled', true);
        $("#connectButton").prop('disabled', true);
        $("#sendMessageButton").prop('disabled', true); 
        console.log("onCloseRequested");
    },
    onConnect: function(frame)
    {
        console.log('Connected: ' + frame);
        var whoami = frame.headers['user-name'];
        console.log("whoami " + whoami);
        chat.isConnected = true;
        $("#disconnectButton").prop('disabled', !chat.isConnected);
        $("#connectButton").prop('disabled', chat.isConnected);
        $("#sendMessageButton").prop('disabled', !chat.isConnected); 
        var headers = {'requestRemoval': false};


        var messageBody =
                JSON.stringify({
                    'userName': whoami
                });


        chat.stompClient.send('/app/registerUserEndpoint', headers, messageBody);
    },
    onActiveMembers: function(activeMembers)
    {
         
        chat_handlers.usersList.empty();
        var imLoggedIn = false;
        var userN = null;
        for (i=0;i<activeMembers.userList.length;i++)
        {
            userN = activeMembers.userList[i].userName;
            console.log("onActiveMembers --> "+ userN);
            var d = $("<div></div>").text(userN);
            d.addClass("list-group-item-success");
            chat_handlers.usersList.append(d);
            if (userN == chat.userName)
            {
                imLoggedIn = true;             
            }
        }
        

        if (imLoggedIn == false)
        {
            chat.stompClient.disconnect();
            console.log("stomp disconnect for "+chat.userName);
            chat_handlers.onClose(null);
        }
    },
    onPublicMessage: function(message)
    {
        // the parameter is the complete message  
        // JSON.parse(message.body) is the body of the message as JSON
        //console.log(message);
        //console.log("message event\n" + message + "\n");
        //sender, message
        var messageObj = JSON.parse(message.body);
        var template = "<div><span class=\"label label-primary\">{{sender}}</span> <span class=\"messageClass\">{{message}}</span></div> ";
        var messageAppendObj = Mustache.to_html(template,messageObj);
        $('#chatArea').append(messageAppendObj);
        
        
    }


};

MESSAGE_PUMP.subscribe(chat_handlers.onError, chat.events.ON_ERROR);
MESSAGE_PUMP.subscribe(chat_handlers.onClose, chat.events.ON_CLOSE);
MESSAGE_PUMP.subscribe(chat_handlers.onCloseRequested, chat.events.ON_CLOSE_REQUESTED);
MESSAGE_PUMP.subscribe(chat_handlers.onPublicMessage, chat.events.ON_PUBLIC_MESSAGE);
MESSAGE_PUMP.subscribe(chat_handlers.onConnect, chat.events.ON_CONNECT);
MESSAGE_PUMP.subscribe(chat_handlers.onActiveMembers, chat.events.ON_ACTIVE_MEMBERS);
  