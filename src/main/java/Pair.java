public class Pair<T, U> {
    T t;
    U u;

    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public T getKey() {
        return t;
    }

    public U getValue() {
        return u;
    }
}
