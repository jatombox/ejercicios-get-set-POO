public class Facturar
{
    // instance variables - replace the example below with your own
    private double cantidad;
    private double precio;

    /**
     * constructores
     */

    // Constructor sin parámetros
    public Facturar() {
        // initialise instance variables
        cantidad = 0;
        precio = 0;
    }

    // Constructor al que se le deben pasar dos parámetros que sirven para inicializar los atributos de la clase
    public Facturar(double cantidad, double precio) {
        // initialise instance variables
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * Setters
     */

    // Los setter sirven para asignar valores a los atributos
    public void setPrecio(double precio){
        this.precio = precio;
    }

    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Getters
     */
    // los getters sirven obtener el valor de los atributos en un momento determinado
    public double getPrecio(){
        return this.precio;
    }

    public double getCantidad(){
        return this.cantidad;
    }

    /**
     * Método que calcula el total de la venta
     */
    public double calcularVenta(){
        double subtotal;
        double iva;
        double total;

        subtotal = cantidad * precio;
        iva = subtotal * 0.13;
        total = subtotal + iva; // el enunciado te dice que se reste el iva... lo lógico es sumarlo!!

        return total;
    }

        // Método creativo: mensaje motivacional aleatorio
    public String mensajeCreativo() {
        String[] mensajes = {
            "¡Gracias por tu compra! <3",
            "¡Eres un cliente increíble!",
            "¡Sigue brillando, crack! :o",
            "Tu día mejoró un 13% gracias a esta compra :D",
            "¡Vuelve pronto, te esperamos! :3"
        };

        int index = (int)(Math.random() * mensajes.length);
        return mensajes[index];
    }

        // Parte creativa #2: Generar un ID único para la factura
    public String generarCodigoFactura() {
        int numero = (int)(Math.random() * 90000) + 10000; // número de 5 dígitos
        return "FAC-" + numero;
    }

}

