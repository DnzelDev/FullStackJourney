package SistemaBancario;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;

    public CuentaCorriente(String titular, double saldo, double limiteSobregiro) {
        super(titular, saldo);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto > getSaldo() + limiteSobregiro) {
            System.out.println("Excede el límite de sobregiro.");
        } else {
            double nuevoSaldo = getSaldo() - monto;
            modificarSaldo(nuevoSaldo);
        }
    }

}
