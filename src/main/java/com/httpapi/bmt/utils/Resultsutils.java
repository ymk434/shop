package com.httpapi.bmt.utils;

import com.httpapi.bmt.model.Result;

public class Resultsutils {

    public static Result Success(Object par) {
      Result s=new Result();
      s.setStatus(200);
      s.setMessage("null");
      s.setData(par);
      return s;
    }



    public  static Result Error(int status,String message) {
        Result s=new Result();
        s.setStatus(status);
        s.setMessage(message);
        s.setData(null);
        return s;
    }
}