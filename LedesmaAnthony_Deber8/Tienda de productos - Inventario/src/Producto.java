public abstract class Producto {

    private String codigo;
    private String nombre;
    protected double precioBase;
    protected int stock;

    public Producto(String codigo, String nombre, double precioBase, int stock) {

        if (codigo == null || codigo.isEmpty() || nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("Código o nombre inválido");

        if (precioBase <= 0)
            throw new PrecioInvalidoException("Precio base inválido");

        if (stock < 0)
            throw new IllegalArgumentException("Stock negativo");

        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public int getStock() {
        return stock;
    }

    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - $" + calcularPrecioFinal() + " - Stock: " + stock;
    }
}

