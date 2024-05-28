package com.example.firstspringbootdemo.exceptions;

//spring provides an in build Exception class which we are using here
//And here we are creating subclass or child class of the Exception class, and we are sending an error message
public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
