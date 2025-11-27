import java.util.Random;

public class Usuario {

    private String titular;
    private long numero_cuenta;
    private double saldo;
    
    // Atributo creativo: Nivel de Lealtad del Cliente
    private int nivelLealtad; // 1: Bronce, 2: Plata, 3: Oro

    public Usuario(String titular, double saldo) {
        this.titular = titular;
        Random aleatorio = new Random();
        this.saldo = saldo;
        this.numero_cuenta = Math.abs(aleatorio.nextLong());
        this.nivelLealtad = 1; // Nivel inicial
    }

    // Método estático para retiros (mejorado con validación)
    public static boolean setRetiros(Usuario cliente, double cantidad) {
        if (cantidad > 0 && cliente.saldo >= cantidad) {
            cliente.saldo -= cantidad;
            // Lógica creativa: Aumentar lealtad por cada retiro exitoso
            if (cliente.saldo > 100000) {
                cliente.nivelLealtad = 3; // Oro
            } else if (cliente.saldo > 50000) {
                cliente.nivelLealtad = 2; // Plata
            } else {
                cliente.nivelLealtad = 1; // Bronce
            }
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente o cantidad no válida para el retiro.");
            return false;
        }
    }

    // Método estático para transferencias (mejorado con validación)
    public static boolean setTransferencia(Usuario titu1, Usuario titu2, double cantidad) {
        if (cantidad > 0 && titu1.saldo >= cantidad) {
            titu1.saldo -= cantidad;
            titu2.saldo += cantidad;
            // Lógica creativa: Aumentar lealtad por cada transferencia exitosa
            if (titu1.saldo > 100000) {
                titu1.nivelLealtad = 3; // Oro
            } else if (titu1.saldo > 50000) {
                titu1.nivelLealtad = 2; // Plata
            } else {
                titu1.nivelLealtad = 1; // Bronce
            }
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente o cantidad no válida para la transferencia.");
            return false;
        }
    }

    // Método para obtener el nivel de lealtad en texto
    public String getNivelLealtad() {
        switch (nivelLealtad) {
            case 3:
                return "Oro (Cliente Premium)";
            case 2:
                return "Plata (Cliente Frecuente)";
            default:
                return "Bronce (Cliente Básico)";
        }
    }

    // Getter para el titular (necesario para POO)
    public String getTitular() {
        return titular;
    }

    // Método para obtener los datos de la cuenta (mejorado)
    public String getDatosCuenta() {
        return "===============================================\n" +
               "  CUENTA CORRIENTE - DETALLE\n" +
               "===============================================\n" +
               "  Titular: " + titular + "\n" +
               "  Número de Cuenta: " + numero_cuenta + "\n" +
               "  Saldo Actual: $" + String.format("%,.2f", saldo) + "\n" +
               "  Nivel de Lealtad: " + getNivelLealtad() + "\n" +
               "===============================================";
    }
    
    // El método getRetiro() original no tenía sentido, se elimina o se renombra si fuera necesario.
    // Lo mantendré renombrado para no borrarlo completamente, aunque su uso es redundante.
    public String getEstadoRetiro() {
        return "Titular: " + titular + " | Saldo actual: $" + String.format("%,.2f", saldo);
    }
}
