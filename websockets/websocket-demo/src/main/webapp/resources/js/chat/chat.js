var chat = {
    socketDest: null,
    isConnected: false,
    userName: null,
    activeMembers: [],
    stompClient: null,
    events: {
        ON_CONNECT: "ON_CONNECT",
        ON_CLOSE: "ON_CLOSE",
        ON_CLOSE_REQUESTED: "ON_CLOSE_REQUESTED",
        ON_ERROR: "ON_ERROR",
        ON_PUBLIC_MESSAGE: "ON_PUBLIC_MESSAGE",
        ON_ACTIVE_MEMBERS: "ON_ACTIVE_MEMBERS"


    },
    init: function(contextPath,userName)
    {
        this.socketDest = contextPath + "/chat";
        this.userName = userName;
       
    },
    connect: function() {
        if ('WebSocket' in window) {
            console.log('Websocket supported');
            console.log('Connection attempted');
            console.log("socket dest '" + this.socketDest + "'");
            var socket = new SockJS(this.socketDest);
            this.stompClient = Stomp.over(socket);
            this.stompClient.connect('', '', function(frame) {
                
                MESSAGE_PUMP.raiseEvent(frame, chat.events.ON_CONNECT);
                
                 
                chat.stompClient.subscribe('/topic/public.chatMessages', function(message) {
                    
                    MESSAGE_PUMP.raiseEvent(message, chat.events.ON_PUBLIC_MESSAGE);
                });
                chat.stompClient.subscribe('/topic/registerUser', function(activeMembersMessage) {
                     console.log("xxx "+activeMembersMessage);
                     var activeMembers = JSON.parse(activeMembersMessage.body);
                     console.log("got something on topic registerUser "+activeMembers);
                     MESSAGE_PUMP.raiseEvent(activeMembers, chat.events.ON_ACTIVE_MEMBERS);
                });
                 
            });



        } else {
            console.log('Websocket not supported');
        }
    },
    closeRequested: function()
    {
       
        var whoami = chat.userName;
        var headers = {'requestRemoval': true};
        console.log("close occurred ", whoami);
        var messageBody =
                JSON.stringify({
                    'userName': chat.userName
                });


        chat.stompClient.send('/app/registerUserEndpoint', headers, messageBody);
        chat.isConnected = false;
        MESSAGE_PUMP.raiseEvent(null, chat.events.ON_CLOSE_REQUESTED);
        
    },
    
    sendMessage: function()
    {
         
        var textToSend = $('#sendMessageTextBox').val();
        console.log("sending "+textToSend);
         var messageBody =
                JSON.stringify({
                    'sender': chat.userName,
                    'message': textToSend
            
                });

        var headers = {};
        chat.stompClient.send('/app/public/chat', headers, messageBody);
    }
};





//function disconnect() {
//    stompClient.disconnect();
//    console.log("Disconnected");
//}
//append a div with the user information

