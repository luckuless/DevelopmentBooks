package com.kata.DevelopmentBooks.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    int statusCode;
    String message;
    Date timestamp;
}
