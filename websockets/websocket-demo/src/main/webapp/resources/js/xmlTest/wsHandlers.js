/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

wsHandlers = {
    
    onError: function(evt)
    {
        console.log("error event ",evt);
    },
    onClose: function(evt)
    {
        console.log("close occurred ",evt);
    },
    onOpen: function(evt)
    {
        console.log("open event");
    },
    onMessage: function(data)
    {
        console.log("message event\n"+data+"\n");
    },
    
    
};

MESSAGE_PUMP.subscribe(wsHandlers.onError,xmlTest.events.ON_ERROR);
MESSAGE_PUMP.subscribe(wsHandlers.onClose,xmlTest.events.ON_CLOSE);
MESSAGE_PUMP.subscribe(wsHandlers.onMessage,xmlTest.events.ON_MESSAGE);
MESSAGE_PUMP.subscribe(wsHandlers.onOpen,xmlTest.events.ON_OPEN);