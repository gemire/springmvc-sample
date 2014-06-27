/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var xmlTest = {
    socketDest: null,
    socket: null,
    isConnected: false,
    events: {
        ON_OPEN: "ON_OPEN", // no payload
        ON_CLOSE: "ON_CLOSE", // no payload
        ON_ERROR: "ON_ERROR", // error event
        ON_MESSAGE: "ON_MESSAGE" // received data


    },
    init: function(s)
    {

        this.socketDest = s;
    },
    connect: function() {
        if ('WebSocket' in window) {
            console.log('Websocket supported');
            console.log('Connection attempted');
            console.log("socket dest '" + this.socketDest + "'");
            this.socket = new WebSocket(this.socketDest);

            this.socket.onopen = function() {
                xmlTest.isConnected = true;
                MESSAGE_PUMP.raiseEvent(null,xmlTest.events.ON_OPEN);
            }

            this.socket.onclose = function(evt) {
               
                MESSAGE_PUMP.raiseEvent(evt,xmlTest.events.ON_CLOSE);
            }
            this.socket.onerror = function(evt)
            {
                MESSAGE_PUMP.raiseEvent(evt,xmlTest.events.ON_ERROR);
                this.socket.onclose = function(e) {
                    console.log('closing error ', e);
                }
            }


            this.socket.onmessage = function(evt)
            {
                var received_msg = evt.data;   
                MESSAGE_PUMP.raiseEvent(received_msg,xmlTest.events.ON_MESSAGE); 
            }
            
        } else {
            console.log('Websocket not supported');
        }
    },
    ///////////////////////////////////////////////////////////////

    getInfo: function()
    {
        if (this.isConnected == true)
        {
            this.socket.send(JSON.stringify({'message': "message"}));
        }
         
    }


};