import java.util.ArrayList;
import java.util.Collections;

public class Concesionaria {

    private ArrayList<Vehiculo> inventario = new ArrayList<>();

    public void agregarVehiculo(Vehiculo v) {
        if (v == null)
            throw new NullPointerException("Vehículo nulo");
        inventario.add(v);
    }

    public double calcularTotalImpuestos() {
        if (inventario.isEmpty())
            throw new IllegalStateException("La lista está vacía");

        double total = 0;
        for (Vehiculo v : inventario)
            total += v.calcularImpuestoCirculacion();
        return total;
    }

    public Vehiculo obtenerVehiculoMasCaro() {
        if (inventario.isEmpty())
            throw new IllegalStateException("Inventario vacío");

        Vehiculo mayor = inventario.get(0);

        for (Vehiculo v : inventario)
            if (v.getPrecio() > mayor.getPrecio())
                mayor = v;

        return mayor;
    }

    public void ordenarPorPrecio() {
        Collections.sort(inventario, (a, b) -> Double.compare(a.getPrecio(), b.getPrecio()));
    }

    public ArrayList<Vehiculo> getInventario() {
        return inventario;
    }
}
