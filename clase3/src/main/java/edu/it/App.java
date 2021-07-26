package edu.it;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            var r = new edu.it.ejemplos.Transacciones();
            r.run();
        }
        catch (Exception ex) {
            System.out.println("**********************************");
            System.out.println("NO SE PUDO REALIZAR LA TRANSACCION");
            System.out.println("**********************************");
        }

    }
}
