package com.httpapi.bmt.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result {

    private  int status;
    private  String  message;
    private  Object data;
}
