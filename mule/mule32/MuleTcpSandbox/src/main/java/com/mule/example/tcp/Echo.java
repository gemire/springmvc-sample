package com.mule.example.tcp;

public class Echo
{
    /* Methods */
    public DataObject echoMessage(DataObject data) {
        System.out.println("data.getId() = " + data.getId());
        data.setId(data.getId()+1);
        return data;
    }
    
    
    public String echoString(String t)
    {
        return t;
    }

}
