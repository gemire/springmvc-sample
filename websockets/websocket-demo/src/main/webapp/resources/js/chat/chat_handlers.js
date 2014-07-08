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
        var whoami = chat.userName;
        var headers = {};
        console.log("close occurred ", whoami);
        var messageBody =
                JSON.stringify({
                    'userName': chat.userName, 'requestRemoval': true
                });


        chat.stompClient.send('/app/registerUser', headers, messageBody);
        chat.isConnected = false;
        $("#disconnectButton").prop('disabled', !chat.isConnected);
        $("#connectButton").prop('disabled', chat.isConnected);
    },
    onConnect: function(frame)
    {
        console.log('Connected: ' + frame);
        var whoami = frame.headers['user-name'];
        console.log("whoami " + whoami);
        chat.isConnected = true;
        $("#disconnectButton").prop('disabled', !chat.isConnected);
        $("#connectButton").prop('disabled', chat.isConnected);
        var headers = {};


        var messageBody =
                JSON.stringify({
                    'userName': whoami, 'requestRemoval': false
                });


        chat.stompClient.send('/app/registerUser', headers, messageBody);
    },
    onActiveMembers: function(activeMembers)
    {
        console.log("on activeMembers \n" + activeMembers + "\n");
    },
    onMessage: function(data)
    {
        console.log("message event\n" + data + "\n");
    }


};

MESSAGE_PUMP.subscribe(chat_handlers.onError, chat.events.ON_ERROR);
MESSAGE_PUMP.subscribe(chat_handlers.onClose, chat.events.ON_CLOSE);
MESSAGE_PUMP.subscribe(chat_handlers.onMessage, chat.events.ON_MESSAGE);
MESSAGE_PUMP.subscribe(chat_handlers.onConnect, chat.events.ON_CONNECT);
MESSAGE_PUMP.subscribe(chat_handlers.onActiveMembers, chat.events.ON_ACTIVE_MEMBERS);
  