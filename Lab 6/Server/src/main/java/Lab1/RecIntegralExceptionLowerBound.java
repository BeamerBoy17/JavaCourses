package Lab1;

public class RecIntegralExceptionLowerBound extends RecIntegralException {
    private static final String info = new String("Значения не могут быть меньше "+RecIntegral.MIN);
    RecIntegralExceptionLowerBound(){
        super();
    }
    String getInfo(){
        return info;
    }
}

