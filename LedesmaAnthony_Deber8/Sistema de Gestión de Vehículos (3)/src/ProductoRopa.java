public class ProductoRopa extends Producto {

    private String talla;
    private String material;

    public ProductoRopa(String codigo, String nombre, double precioBase, int stock, String talla, String material) {
        super(codigo, nombre, precioBase, stock);

        if (talla == null || talla.isEmpty() || material == null || material.isEmpty())
            throw new IllegalArgumentException("Talla o material inválido");
        this.talla = talla;
        this.material = material;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.12;
    }
}
