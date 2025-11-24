public class DVD extends MaterialBiblioteca {

    private int duracionMinutos;
    private String genero;
    private boolean tieneSubtitulos;

    public DVD(String codigo, String titulo, String autor, int anioPublicacion, int duracionMinutos, String genero, boolean tieneSubtitulos) {
        super(codigo, titulo, autor, anioPublicacion);
        if (duracionMinutos <= 0 || genero == null || genero.isEmpty())
            throw new IllegalArgumentException("Duración o género inválido");

        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.tieneSubtitulos = tieneSubtitulos;
    }

    @Override
    public double calcularMultaPorRetraso(int dias) {
        if (dias < 0)
            throw new IllegalArgumentException("Días inválidos");

        return dias * 1.50;
    }

    public double calcularMultaPorRetraso(int dias, boolean esEstreno) {
        double base = calcularMultaPorRetraso(dias);
        return esEstreno ? base * 2 : base;
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return 3;
    }
}

