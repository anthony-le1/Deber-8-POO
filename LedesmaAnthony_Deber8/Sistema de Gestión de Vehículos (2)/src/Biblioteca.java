import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<MaterialBiblioteca> catalogo = new ArrayList<>();
    private String nombre;

    public Biblioteca(String nombre) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre;
    }

    public static void validarCodigo(String codigo) throws CodigoInvalidoException {
        if (!(codigo.startsWith("Lib-") || codigo.startsWith("Rev-") || codigo.startsWith("DVD-")))
            throw new CodigoInvalidoException("Código inválido: " + codigo);
    }

    public static String generarCodigoAleatorio(String tipo) {
        int num = (int)(Math.random() * 900 + 100);
        return tipo + "-" + num;
    }

    public void agregarMaterial(MaterialBiblioteca m) throws CodigoInvalidoException {
        if (m == null)
            throw new NullPointerException("Material nulo");

        validarCodigo(m.getCodigo());
        catalogo.add(m);
    }

    public MaterialBiblioteca buscarMaterial(String codigo) {
        for (MaterialBiblioteca m : catalogo)
            if (m.getCodigo().equals(codigo))
                return m;

        throw new MaterialNoEncontradoException("No encontrado: " + codigo);
    }

    public void prestarMaterial(String codigo) {
        MaterialBiblioteca m = buscarMaterial(codigo);

        if (m.isPrestado())
            throw new MaterialNoDisponibleException("Ya prestado");

        m.prestar();
    }

    public double devolverMaterial(String codigo, int diasRetraso) {
        if (diasRetraso < 0)
            throw new IllegalArgumentException("Días inválidos");

        MaterialBiblioteca m = buscarMaterial(codigo);
        m.devolver();
        return m.calcularMultaPorRetraso(diasRetraso);
    }

    public void listarMaterialesDisponibles() {
        for (MaterialBiblioteca m : catalogo)
            if (!m.isPrestado())
                System.out.println(m);
    }

    // Ordenar por año
    public void ordenarPorAnio() {
        for (int i = 0; i < catalogo.size() - 1; i++) {
            for (int j = 0; j < catalogo.size() - 1 - i; j++) {
                if (catalogo.get(j).toString().compareTo(catalogo.get(j + 1).toString()) > 0) {
                    MaterialBiblioteca aux = catalogo.get(j);
                    catalogo.set(j, catalogo.get(j + 1));
                    catalogo.set(j + 1, aux);
                }
            }
        }
    }

    public ArrayList<MaterialBiblioteca> getCatalogo() {
        return catalogo;
    }
}

