import java.util.ArrayList;

public class Banco {

    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    private String nombre;

    public Banco(String nombre) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre;
    }

    public static String generarNumeroCuenta() {
        String numero = "";
        for (int i = 0; i < 10; i++)
            numero += (int) (Math.random() * 10);
        return numero;
    }

    public void abrirCuenta(CuentaBancaria c) {
        if (c == null)
            throw new NullPointerException("Cuenta nula");

        cuentas.add(c);
    }

    public void transferir(String origen, String destino, double monto)
            throws SaldoInsuficienteException {

        if (monto <= 0)
            throw new MontoInvalidoException("Monto inválido");

        CuentaBancaria o = null, d = null;

        for (CuentaBancaria c : cuentas) {
            if (c.getNumeroCuenta().equals(origen)) o = c;
            if (c.getNumeroCuenta().equals(destino)) d = c;
        }

        if (o == null || d == null)
            throw new IllegalArgumentException("Cuenta no encontrada");

        o.retirar(monto);
        d.depositar(monto);
    }

    public void aplicarInteresesAhorros() {
        for (CuentaBancaria c : cuentas) {
            if (c instanceof CuentaAhorros ah) {
                if (ah.getSaldo() == 0)
                    throw new CuentaInactivaException("Cuenta sin saldo");

                ah.aplicarInteres();
            }
        }
    }

    public double obtenerSaldoTotal() {
        if (cuentas.isEmpty())
            throw new IllegalStateException("No hay cuentas");

        double total = 0;
        for (CuentaBancaria c : cuentas)
            total += c.getSaldo();
        return total;
    }

    // Ordenar manualmente por saldo
    public void ordenarPorSaldo() {
        for (int i = 0; i < cuentas.size() - 1; i++) {
            for (int j = 0; j < cuentas.size() - 1 - i; j++) {
                if (cuentas.get(j).getSaldo() > cuentas.get(j + 1).getSaldo()) {
                    CuentaBancaria temp = cuentas.get(j);
                    cuentas.set(j, cuentas.get(j + 1));
                    cuentas.set(j + 1, temp);
                }
            }
        }
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }
}

