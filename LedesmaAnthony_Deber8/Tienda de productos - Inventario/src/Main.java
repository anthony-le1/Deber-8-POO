public class Main {
    public static void main(String[] args) {

        Inventario inv = new Inventario("Tienda EPN");

        try {
            new ProductoElectronico("ELEC-1", "Celular", -100, 10, "Samsung", 12);
        } catch (Exception e) {
            System.out.println("Error precio negativo: " + e.getMessage());
        }

        try {
            new ProductoRopa("", "Camisa", 20, 5, "M", "Algodón");
        } catch (Exception e) {
            System.out.println("Error código vacío: " + e.getMessage());
        }

        //  PRODUCTOS VÁLIDOS
        inv.agregarProducto(new ProductoElectronico( Inventario.generarCodigo("Electro"), "Laptop", 800, 5, "Apple", 12));
        inv.agregarProducto(new ProductoElectronico(Inventario.generarCodigo("Electro"), "Tablet", 500, 2, "LG", 24));
        inv.agregarProducto(new ProductoAlimenticio(Inventario.generarCodigo("Alimen"), "Leche", 1.2, 20, "20/12/2025", true));
        inv.agregarProducto(new ProductoAlimenticio(Inventario.generarCodigo("Alimen"), "Pan", 0.5, 50, "10/02/2025", false));
        inv.agregarProducto(new ProductoRopa(Inventario.generarCodigo("Ropa"), "Pantalón", 25, 10, "32", "Jean"));
        inv.agregarProducto(new ProductoRopa(Inventario.generarCodigo("Ropa"), "Chaqueta", 45, 3, "L", "Cuero"));
        inv.agregarProducto(new ProductoRopa(Inventario.generarCodigo("Ropa"), "Gorra", 10, 4, "Única", "Tela"));
        inv.agregarProducto(new ProductoAlimenticio(Inventario.generarCodigo("Alimen"), "Queso", 3.5, 8, "22/03/2025", true));
        inv.agregarProducto(new ProductoElectronico(Inventario.generarCodigo("Electro"), "Auriculares", 15, 12, "Sony", 6));
        inv.agregarProducto(new ProductoElectronico(Inventario.generarCodigo("Electro"), "Teclado", 20, 7, "Logitech", 12));

        // VENTAS
        try {
            double total = inv.venderProducto(inv.getProductos().get(0).getCodigo(), 2);
            System.out.println("Venta exitosa: $" + total);
        } catch (Exception e) {
            System.out.println("Error venta: " + e.getMessage());
        }

        // Venta inválida
        try {
            inv.venderProducto(inv.getProductos().get(1).getCodigo(), 1000);
        } catch (Exception e) {
            System.out.println("Error venta stock insuficiente: " + e.getMessage());
        }

        // Buscar producto inexistente
        try {
            inv.buscarPorCodigo("XXXX");
        } catch (Exception e) {
            System.out.println("Error búsqueda: " + e.getMessage());
        }

        // VALOR TOTAL DE INVENTARIO
        System.out.println("Valor total inventario: $" + inv.calcularValorInventario());

        // Productos bajo stock
        System.out.println("\nProductos con stock < 5:");
        for (Producto p : inv.listarProductosBajoStock(5))
            System.out.println(p);

        // Ordenar por precio
        inv.ordenarPorPrecio();

        System.out.println("\nInventario ordenado por precio:");
        for (Producto p : inv.getProductos())
            System.out.println(p);
    }
}

