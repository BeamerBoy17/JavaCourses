package Lab1;

public class RecIntegralExceptionUpperBound extends RecIntegralException {
    private static final String info = new String("Значения не могут быть больше "+RecIntegral.MAX);
    RecIntegralExceptionUpperBound() {
        super();
    }
    String getInfo(){
        return info;
    }
}