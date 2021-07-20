package edu.it.ejemplos;

import java.util.Optional;

public class NocionDelOptional implements Runnable {
    private Optional<Integer> division(int x, int y) {
        if (y==0) {
            return Optional.empty();
        }
        return Optional.of(x / y);
    }
    private Integer suma(int x, int y) {
        return x + y;
    }
    public void run() {
        var optInt = division(2, suma(-2, 2));
        System.out.println(optInt.get().floatValue());
    }
}
