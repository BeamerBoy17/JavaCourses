package com.company;

public class RecIntegralExceptionUpperBound extends RecIntegralException {
    private static final String info = new String("�������� �� ����� ���� ������ "+RecIntegral.MAX);
    RecIntegralExceptionUpperBound() {
        super();
    }
    String getInfo(){
        return info;
    }
}

