public class Revista extends MaterialBiblioteca {

    private int numeroEdicion;
    private String mesPublicacion;
    private boolean esEspecializada;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion, String mesPublicacion, boolean esEspecializada) {
        super(codigo, titulo, autor, anioPublicacion);
        if (numeroEdicion <= 0 || mesPublicacion == null || mesPublicacion.isEmpty())
            throw new IllegalArgumentException("Edición o mes inválido");

        this.numeroEdicion = numeroEdicion;
        this.mesPublicacion = mesPublicacion;
        this.esEspecializada = esEspecializada;
    }

    @Override
    public double calcularMultaPorRetraso(int dias) {
        if (dias < 0)
            throw new IllegalArgumentException("Días inválidos");

        return esEspecializada ? dias * 2.00 : dias * 0.75;
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return esEspecializada ? 5 : 7;
    }
}
