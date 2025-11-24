public class CuentaInversion extends CuentaBancaria {

    private double montoMinimo;
    private double rendimientoAnual;

    public CuentaInversion(String numero, String titular, double saldo,
                           double montoMinimo, double rendimientoAnual) {

        super(numero, titular, saldo);

        if (montoMinimo <= 0 || rendimientoAnual < 0)
            throw new IllegalArgumentException("Valores inválidos");

        this.montoMinimo = montoMinimo;
        this.rendimientoAnual = rendimientoAnual;
    }

    @Override
    public void depositar(double monto) {
        if (monto < montoMinimo)
            throw new MontoInvalidoException("El monto es menor al mínimo permitido");

        saldo += monto;
    }

    public double calcularRendimiento() {
        return saldo * (rendimientoAnual / 12);
    }

    public double calcularRendimiento(int meses) {
        return saldo * (rendimientoAnual / 12) * meses;
    }
}
