import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        double totalApagar;
        Scanner entrada = new Scanner (System.in);

        System.out.print("introduzca la cantidad de articulos: ");
        double cant = entrada.nextDouble();

        System.out.print("introduzca el precio: ");
        double price = entrada.nextDouble();

        System.out.println ("cantidad: "+cant);
        Facturar miFactura = new Facturar (cant, price);
        totalApagar = miFactura.calcularVenta();

        System.out.println("\n el total de la factura es: " + totalApagar);
        System.out.println("Mensaje especial: " + miFactura.mensajeCreativo());
        System.out.println("Código de factura: " + miFactura.generarCodigoFactura());

        entrada.close();
    }
}
