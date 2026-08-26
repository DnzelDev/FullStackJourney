package SistemaBancario;

public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;

    public CuentaAhorros(String titular, double saldo, double tasaInteres) {
        super(titular, saldo);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void aplicarInteres() {
        double interes = getSaldo() * (tasaInteres / 100);
        double nuevoSaldo = getSaldo() + interes;
        setSaldo(nuevoSaldo);
    }

}
