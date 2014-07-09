/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

chat_handlers = {
    onError: function(evt)
    {
        console.log("error event ", evt);
    },
    onClose: function(evt)
    {
        
        $("#disconnectButton").prop('disabled', !chat.isConnected);
        $("#connectButton").prop('disabled', chat.isConnected);
        console.log("onClose");
    },
    
    onCloseRequested: function(evt)
    {
        
        $("#disconnectButton").prop('disabled', true);
        $("#connectButton").prop('disabled', true);
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
        var headers = {'requestRemoval': false};


        var messageBody =
                JSON.stringify({
                    'userName': whoami, 'requestRemoval': false
                });


        chat.stompClient.send('/app/registerUserEndpoint', headers, messageBody);
    },
    onActiveMembers: function(activeMembers)
    {
        var imLoggedIn = false;
        var userN = null;
        for (i=0;i<activeMembers.userList.length;i++)
        {
            userN = activeMembers.userList[i].userName;
            console.log("onActiveMembers --> "+ userN);
            if (userN == chat.userName)
            {
                imLoggedIn = true;
                break;
            }
        }

        if (imLoggedIn == false)
        {
            chat.stompClient.disconnect();
            console.log("stomp disconnect for "+chat.userName);
            chat_handlers.onClose(null);
        }
    },
    onMessage: function(data)
    {
        console.log("message event\n" + data + "\n");
    }


};

MESSAGE_PUMP.subscribe(chat_handlers.onError, chat.events.ON_ERROR);
MESSAGE_PUMP.subscribe(chat_handlers.onClose, chat.events.ON_CLOSE);
MESSAGE_PUMP.subscribe(chat_handlers.onCloseRequested, chat.events.ON_CLOSE_REQUESTED);
MESSAGE_PUMP.subscribe(chat_handlers.onMessage, chat.events.ON_MESSAGE);
MESSAGE_PUMP.subscribe(chat_handlers.onConnect, chat.events.ON_CONNECT);
MESSAGE_PUMP.subscribe(chat_handlers.onActiveMembers, chat.events.ON_ACTIVE_MEMBERS);
  