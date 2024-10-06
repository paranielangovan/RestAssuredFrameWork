package com.Utility;

public enum Constant {

    getRequest("maps/api/place/get/json"),
    createRequest("/maps/api/place/add/json"),
    putRequest("maps/api/place/update/json"),
    deleteRequest("maps/api/place/delete/json");
   private String HttpMethods;

    Constant(String s) {
        this.HttpMethods = s;
    }
    public String getSource(){
        return  HttpMethods;
    }

}
