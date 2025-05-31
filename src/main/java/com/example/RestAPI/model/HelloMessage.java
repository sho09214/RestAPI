package com.example.RestAPI.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class HelloMessage {

    private String strMessage;

    public HelloMessage(String inMsg){
        this.strMessage = inMsg;
    }

}
