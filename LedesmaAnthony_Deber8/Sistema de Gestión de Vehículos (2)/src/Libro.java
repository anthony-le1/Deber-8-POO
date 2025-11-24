public class Libro extends MaterialBiblioteca {

    private int numPaginas;
    private String editorial;
    private boolean esDigital;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numPaginas, String editorial, boolean esDigital) {
        super(codigo, titulo, autor, anioPublicacion);
        if (numPaginas <= 0 || editorial == null || editorial.isEmpty())
            throw new IllegalArgumentException("Páginas o editorial inválida");
        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.esDigital = esDigital;
    }

    @Override
    public double calcularMultaPorRetraso(int dias) {
        if (dias < 0)
            throw new IllegalArgumentException("Días inválidos");

        return esDigital ? dias * 0.50 : dias * 1.00;
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return esDigital ? 7 : 15;
    }
}

