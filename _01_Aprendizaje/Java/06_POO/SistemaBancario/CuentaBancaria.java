package SistemaBancario;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("Lo sentimos, el saldo no puede ser negativo. Intente de nuevo.");
        } else {
            this.saldo = saldo;
        }
    }

    public void retirar(double monto) {
        if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
        }
    }

    protected void modificarSaldo(double nuevoSaldo) {
        saldo = nuevoSaldo;
    }

}
