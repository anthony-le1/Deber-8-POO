public class CuentaBancaria {

    private String numeroCuenta;
    private String titular;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if (numeroCuenta == null || numeroCuenta.isEmpty() || titular == null || titular.isEmpty())
            throw new IllegalArgumentException("Número o titular inválidos");

        if (saldo < 0)
            throw new IllegalArgumentException("Saldo negativo no permitido");

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0)
            throw new MontoInvalidoException("Monto inválido");

        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0)
            throw new MontoInvalidoException("Monto inválido");

        if (monto > saldo)
            throw new SaldoInsuficienteException("Saldo insuficiente");

        saldo -= monto;
    }

    @Override
    public String toString() {
        return numeroCuenta + " - " + titular + " - $" + saldo;
    }
}
