package com.example.shippingservice.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){
        super("Bad Request");
    }
}
