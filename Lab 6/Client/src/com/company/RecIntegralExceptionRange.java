package com.company;

public class RecIntegralExceptionRange extends RecIntegralException {
    private static final String info =  new String("������ ������� �� ����� ���� ������ �������");
    RecIntegralExceptionRange() {
        super();
    }
    String getInfo(){
        return info;
    }
}
