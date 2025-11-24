public class Auto extends Vehiculo {

    private int numeroPuertas;


    public Auto(String marca, String modelo, int año, double precio) {
        this(marca, modelo, año, precio, 4);
    }

    // Constructor completo
    public Auto(String marca, String modelo, int año, double precio, int numeroPuertas) {
        super(marca, modelo, año, precio);

        if (numeroPuertas <= 0)
            throw new IllegalArgumentException("Número de puertas inválido");

        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularImpuestoCirculacion() {
        return getPrecio() * 0.05;
    }

    @Override
    public String toString() {
        return "Auto: " + super.toString() + " | Puertas: " + numeroPuertas;
    }
}
