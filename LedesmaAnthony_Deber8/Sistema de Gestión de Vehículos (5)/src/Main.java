public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Banco EPN");

        try {
            new CuentaAhorros("", "Anthony", 100, 0.05);
        } catch (Exception e) {
            System.out.println("Error cuenta: " + e.getMessage());
        }

        try {
            new CuentaCorriente(Banco.generarNumeroCuenta(), "Luis", -20, 100);
        } catch (Exception e) {
            System.out.println("Error saldo negativo: " + e.getMessage());
        }

        // cuentas válidas
        CuentaAhorros c1 = new CuentaAhorros(Banco.generarNumeroCuenta(), "Anthony", 300, 0.05);
        CuentaAhorros c2 = new CuentaAhorros(Banco.generarNumeroCuenta(), "Santiago", 500, 0.03);
        CuentaCorriente c3 = new CuentaCorriente(Banco.generarNumeroCuenta(), "Erik", 100, 200);
        CuentaCorriente c4 = new CuentaCorriente(Banco.generarNumeroCuenta(), "Diego", 300, 100);
        CuentaInversion c5 = new CuentaInversion(Banco.generarNumeroCuenta(), "Jairo", 1000, 50, 0.12);
        CuentaInversion c6 = new CuentaInversion(Banco.generarNumeroCuenta(), "Amy", 2000, 100, 0.10);

        banco.abrirCuenta(c1);
        banco.abrirCuenta(c2);
        banco.abrirCuenta(c3);
        banco.abrirCuenta(c4);
        banco.abrirCuenta(c5);
        banco.abrirCuenta(c6);

        // Movimientos
        c1.depositar(100);
        c3.depositar(50);

        try {
            c1.retirar(5000); // forzar error
        } catch (Exception e) {
            System.out.println("Retiro fallido: " + e.getMessage());
        }

        try {
            banco.transferir(c3.getNumeroCuenta(), c1.getNumeroCuenta(), 200);
            System.out.println("Transferencia OK");
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        // Saldo total
        System.out.println("Saldo total del banco: " + banco.obtenerSaldoTotal());

        // Intereses
        try {
            banco.aplicarInteresesAhorros();
            System.out.println("Intereses aplicados");
        } catch (Exception e) {
            System.out.println("Error intereses: " + e.getMessage());
        }

        // Ordenar por saldo
        banco.ordenarPorSaldo();

        System.out.println("\n====== Cuentas ordenadas por saldo =======");
        for (CuentaBancaria c : banco.getCuentas())
            System.out.println(c);
    }
}
