package com.company;

public class RecIntegralExceptionRange extends RecIntegralException {
    private static final String info =  new String("Нижняя граница не может быть больше верхней");
    RecIntegralExceptionRange() {
        super();
    }
    String getInfo(){
        return info;
    }
}
