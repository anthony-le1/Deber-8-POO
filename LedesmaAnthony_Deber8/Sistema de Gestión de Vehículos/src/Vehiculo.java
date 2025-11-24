public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private int año;
    private double precio;

    public Vehiculo(String marca, String modelo, int año, double precio) {
        if (marca == null || marca.isEmpty() || modelo == null || modelo.isEmpty())
            throw new IllegalArgumentException("Marca o modelo inválidos");

        if (año < 1900 || año > 2025)
            throw new IllegalArgumentException("Año fuera de rango");

        if (precio <= 0)
            throw new IllegalArgumentException("Precio inválido");

        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract double calcularImpuestoCirculacion();

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + año + ") - $" + precio;
    }
}
