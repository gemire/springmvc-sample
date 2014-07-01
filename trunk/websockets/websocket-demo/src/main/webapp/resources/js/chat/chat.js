var chat = {
    socketDest: null,
    isConnected: false,
    activeMembers: [],
    stompClient: null,
    events: {
        ON_CONNECT: "ON_CONNECT",
        ON_CLOSE: "ON_CLOSE",
        ON_ERROR: "ON_ERROR",
        ON_MESSAGE: "ON_MESSAGE",
        ON_ACTIVE_MEMBERS: "ON_ACTIVE_MEMBERS"


    },
    init: function(contextPath)
    {
        this.socketDest = contextPath + "/chat";
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
                chat.stompClient.subscribe('/user/queue/messages', function(message) {
                    MESSAGE_PUMP.raiseEvent(JSON.parse(message.body), chat.events.ON_MESSAGE);
                });
                chat.stompClient.subscribe('/topic/active', function(activeMembers) {
                     MESSAGE_PUMP.raiseEvent(activeMembers, chat.events.ON_ACTIVE_MEMBERS);
                });
            });



        } else {
            console.log('Websocket not supported');
        }
    },
    close: function()
    {
        this.stompClient.disconnect();
        MESSAGE_PUMP.raiseEvent(null, chat.events.ON_CLOSE);
    }
};





//function disconnect() {
//    stompClient.disconnect();
//    console.log("Disconnected");
//}
//append a div with the user information

