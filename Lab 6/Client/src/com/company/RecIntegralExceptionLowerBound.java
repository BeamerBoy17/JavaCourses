package com.company;

public class RecIntegralExceptionLowerBound extends RecIntegralException {
    private static final String info = new String("�������� �� ����� ���� ������ "+RecIntegral.MIN);
    RecIntegralExceptionLowerBound(){
        super();
    }
    String getInfo(){
        return info;
    }
}

