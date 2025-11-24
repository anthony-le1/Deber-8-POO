public class CuentaAhorros extends CuentaBancaria {

    private double tasaInteres;  // entre 0 y 1

    public CuentaAhorros(String numero, String titular, double saldo, double tasaInteres) {
        super(numero, titular, saldo);

        if (tasaInteres < 0 || tasaInteres > 1)
            throw new IllegalArgumentException("Tasa fuera de rango");

        this.tasaInteres = tasaInteres;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0)
            throw new MontoInvalidoException("Monto inválido");

        if ((saldo - monto) < 50)
            throw new SaldoInsuficienteException("El saldo no puede quedar menor a 50");

        saldo -= monto;
    }

    public void aplicarInteres() {
        saldo += saldo * tasaInteres;
    }
}

