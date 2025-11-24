public class Main {
    public static void main(String[] args) {

        Concesionaria c = new Concesionaria();

        try {
            Auto a = new Auto("Toyota", "Corolla", 1800, 15000);
        } catch (Exception e) {
            System.out.println("Error año: " + e.getMessage());
        }

        try {
            Moto m = new Moto("Yamaha", "FZ", 2020, -5000, 150);
        } catch (Exception e) {
            System.out.println("Error precio: " + e.getMessage());
        }

        c.agregarVehiculo(new Auto("Chevrolet", "Spark", 2020, 9000));
        c.agregarVehiculo(new Auto("Kia", "Rio", 2021, 12000, 5));

        c.agregarVehiculo(new Moto("Yamaha", "R3", 2023, 6000, 321));
        c.agregarVehiculo(new Moto("Suzuki", "GN", 2022, 3500, 150));

        c.agregarVehiculo(new Camion("Hino", "300", 2019, 30000, 3));
        c.agregarVehiculo(new Camion("Volvo", "FH", 2021, 90000, 10));

        try {
            Concesionaria vacia = new Concesionaria();
            vacia.calcularTotalImpuestos();
        } catch (Exception e) {
            System.out.println("Error lista vacía: " + e.getMessage());
        }

        System.out.println("\nTotal de impuestos: " + c.calcularTotalImpuestos());

        System.out.println("Vehículo más caro: " + c.obtenerVehiculoMasCaro());

        c.ordenarPorPrecio();
        System.out.println("\n====== Inventario Ordenado =======");
        for (Vehiculo v : c.getInventario()) {
            System.out.println(v);
        }
    }
}

