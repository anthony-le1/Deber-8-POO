public class ProductoElectronico extends Producto {

    private String marca;
    private int garantiaMeses;

    public ProductoElectronico(String codigo, String nombre, double precioBase,
                               int stock, String marca, int garantiaMeses) {

        super(codigo, nombre, precioBase, stock);

        if (marca == null || marca.isEmpty() || garantiaMeses <= 0)
            throw new IllegalArgumentException("Marca o garantía inválida");

        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.12; // 12% IVA
    }

    public boolean aplicarGarantia() {
        return garantiaMeses == 12;
    }

    public double aplicarGarantia(int mesesExtra) {
        if (mesesExtra <= 0)
            throw new IllegalArgumentException("Meses inválidos");
        return mesesExtra * 5.0; // costo adicional
    }
}
