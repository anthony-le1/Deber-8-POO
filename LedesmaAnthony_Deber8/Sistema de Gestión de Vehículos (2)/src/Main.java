public class Main {
    public static void main(String[] args) {

        Biblioteca b = new Biblioteca("Biblioteca EPN");

        try {
            new Libro("", "Titulo", "Autor", 2020, 100, "Planeta", false);
        } catch (Exception e) {
            System.out.println("Error título vacío: " + e.getMessage());
        }

        try {
            new Revista("REV-001", "Revista", "Autor", 900, 5, "Enero", false);
        } catch (Exception e) {
            System.out.println("Error año: " + e.getMessage());
        }

        //  MATERIALES VÁLIDOS
        try {
            b.agregarMaterial(new Libro(Biblioteca.generarCodigoAleatorio("Lib"), "POO", "Anthony", 2010, 200, "EPN Press", false));
            b.agregarMaterial(new Libro(Biblioteca.generarCodigoAleatorio("Lib"), "Programación", "Ledesma", 2015, 300, "Tech", true));
            b.agregarMaterial(new Revista(Biblioteca.generarCodigoAleatorio("Rev"), "Ciencia", "Perez", 2023, 12, "Febrero", true));
            b.agregarMaterial(new Revista(Biblioteca.generarCodigoAleatorio("Rev"), "Tecnología", "Ruiz", 2024, 8, "Agosto", false));
            b.agregarMaterial(new DVD(Biblioteca.generarCodigoAleatorio("DVD"), "Matrix", "WB", 1999, 130, "Accion", true));
            b.agregarMaterial(new DVD(Biblioteca.generarCodigoAleatorio("DVD"), "Avatar", "Fox", 2009, 160, "SciFi", true));
            b.agregarMaterial(new Libro(Biblioteca.generarCodigoAleatorio("Lib"), "IA", "Turing", 1950, 150, "SciPub", false));
            b.agregarMaterial(new Revista(Biblioteca.generarCodigoAleatorio("Rev"), "Robotica", "Chen", 2022, 4, "Junio", true));

        } catch (Exception e) {
            System.out.println("Error agregando: " + e.getMessage());
        }
        // PRÉSTAMOS
        MaterialBiblioteca m1 = b.getCatalogo().get(0);
        MaterialBiblioteca m2 = b.getCatalogo().get(1);
        MaterialBiblioteca m3 = b.getCatalogo().get(2);
        MaterialBiblioteca m4 = b.getCatalogo().get(3);

        b.prestarMaterial(m1.getCodigo());
        b.prestarMaterial(m2.getCodigo());
        b.prestarMaterial(m3.getCodigo());
        b.prestarMaterial(m4.getCodigo());

        // Intentar prestar uno ya prestado
        try {
            b.prestarMaterial(m1.getCodigo());
        } catch (Exception e) {
            System.out.println("Préstamo fallido: " + e.getMessage());
        }

        // Buscar inexistente
        try {
            b.buscarMaterial("XXXX");
        } catch (Exception e) {
            System.out.println("Búsqueda fallida: " + e.getMessage());
        }

        // Devoluciones con multa
        System.out.println("\nMulta por devolución: " +
                b.devolverMaterial(m1.getCodigo(), 3));

        System.out.println("Multa por devolución: " +
                b.devolverMaterial(m2.getCodigo(), 6));

        // Listar disponibles
        System.out.println("\nMateriales disponibles:");
        b.listarMaterialesDisponibles();

        // Ordenar por año
        System.out.println("\nOrdenado por año:");
        b.ordenarPorAnio();
        for (MaterialBiblioteca m : b.getCatalogo())
            System.out.println(m);
    }
}

