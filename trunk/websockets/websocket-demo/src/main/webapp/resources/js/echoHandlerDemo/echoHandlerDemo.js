/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//var socketDest = contextPath + "//echoHandler";

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    if ('WebSocket' in window) {
        console.log('Websocket supported');
        console.log("socket dest "+socketDest);
        socket = new WebSocket(socketDest);

        console.log('Connection attempted xxx');

        socket.onopen = function() {
            console.log('Connection open!');
            setConnected(true);
        }

        socket.onclose = function() {
            console.log('Disconnecting connection');
        }
        socket.onerror=function (evt) 
        {
            console.log('on error '+evt);
            socket.onclose = function(e) {
                console.log('closing error ',e);
            }
        }
            
  
        socket.onmessage = function(evt)
        {
            var received_msg = evt.data;
            console.log(received_msg);
            console.log('message received!');
            showMessage(received_msg);
        }

    } else {
        console.log('Websocket not supported');
    }
}

function disconnect() {
      
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var message = document.getElementById('txtSendMessage').value;
    socket.send(JSON.stringify({'message': message}));
}

function showMessage(message) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    response.appendChild(p);
}
