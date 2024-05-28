package com.example.firstspringbootdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    //Now here we are sending message to the client what is happening in the backend in case of an error
    private String message;
}
