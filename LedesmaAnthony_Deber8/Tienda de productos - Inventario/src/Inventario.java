import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos = new ArrayList<>();
    private String nombreTienda;

    public Inventario(String nombreTienda) {
        if (nombreTienda == null || nombreTienda.isEmpty())
            throw new IllegalArgumentException("Nombre inválido");
        this.nombreTienda = nombreTienda;
    }

    public static String generarCodigo(String categoria) {
        int num = (int) (Math.random() * 9000 + 1000);
        return categoria + "-" + num;
    }

    public void agregarProducto(Producto p) {
        if (p == null)
            throw new NullPointerException("Producto nulo");
        productos.add(p);
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo))
                return p;
        }
        throw new ProductoNoEncontradoException("No existe: " + codigo);
    }

    public double venderProducto(String codigo, int cantidad)
            throws StockInsuficienteException {

        if (cantidad <= 0)
            throw new IllegalArgumentException("Cantidad inválida");

        Producto p = buscarPorCodigo(codigo);

        if (p.stock < cantidad)
            throw new StockInsuficienteException("Stock insuficiente");

        p.stock -= cantidad;

        return cantidad * p.calcularPrecioFinal();
    }

    public double calcularValorInventario() {
        if (productos.isEmpty())
            throw new IllegalStateException("Inventario vacío");

        double total = 0;

        for (Producto p : productos)
            total += p.calcularPrecioFinal() * p.stock;

        return total;
    }

    public ArrayList<Producto> listarProductosBajoStock(int minimo) {
        ArrayList<Producto> lista = new ArrayList<>();
        for (Producto p : productos)
            if (p.stock < minimo)
                lista.add(p);
        return lista;
    }

    // Ordenar manualmente por precio final
    public void ordenarPorPrecio() {
        for (int i = 0; i < productos.size() - 1; i++) {
            for (int j = 0; j < productos.size() - 1 - i; j++) {
                if (productos.get(j).calcularPrecioFinal() >
                        productos.get(j + 1).calcularPrecioFinal()) {

                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Inventario de " + nombreTienda + " - " + productos.size() + " productos";
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}

