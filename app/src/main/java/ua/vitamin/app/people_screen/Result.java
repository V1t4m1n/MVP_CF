package ua.vitamin.app.people_screen;

public class Result<Value> {
    private Value value = null;
    private Throwable throwable = null;

    private Result(Value value, Throwable throwable) {
        this.value = value;
        this.throwable = throwable;
    }

    public static <V> Result<V> value(V value) {
        return new Result<V>(value,null);
    }

    public static <V> Result<V> throwable(Throwable throwable) {
        return new Result<V>(null,throwable);
    }

    public Value getValue() {
        return value;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
