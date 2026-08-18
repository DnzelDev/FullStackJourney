package SistemaBancario;

public class Main01 {
    public static void main(String[] Args) {
        CuentaBancaria c1 = new CuentaBancaria("Kenny", 10);
        CuentaBancaria c2 = new CuentaBancaria("Stan", 150);
        CuentaAhorros ca = new CuentaAhorros("Kyle", 120, 5);
        CuentaCorriente cc = new CuentaCorriente("Cartman", 100, 50);

        c1.setSaldo(-201);
        System.out.println(c1.getSaldo() + " es el saldo de c1.");

        c2.setSaldo(53);
        System.out.println(c2.getSaldo() + " es el saldo de c2");

        System.out.println(ca.getSaldo() + " es el saldo original de ca.");
        ca.aplicarInteres();
        System.out.println(ca.getSaldo() + " es el saldo con los intereses aplicados.");

        c1.retirar(20);
        System.out.println(c1.getSaldo() + " es el saldo c1 despues de retirar sobrepasando el sobregiro");

        cc.retirar(151);
        System.out.println(cc.getSaldo() + " es el saldo sobrepasando el sobregiro.");
    }
}
