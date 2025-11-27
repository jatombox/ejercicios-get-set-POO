import java.util.Scanner;

public class CuentaCorriente {

    public static void main(String[] args) {

        double monto;
        // Se usa try-with-resources para asegurar que el Scanner se cierre
        try (Scanner scn = new Scanner(System.in)) {

            // Se asume que Usuario ya no necesita la clase Persona, pero se mantiene la estructura.
            // Si Usuario debiera heredar de Persona, la lógica sería diferente.
            // Por ahora, se mantiene la estructura original de instanciación.
            Usuario cuenta1 = new Usuario("Juan Perrez", 22000.00);
            Usuario cuenta2 = new Usuario("Diana Prince", 178000.50);

            System.out.println("\n***********************************************");
            System.out.println("       BIENVENIDO AL BANCO Bancolombia-POO");
            System.out.println("***********************************************");
            System.out.println("Cuentas disponibles para operar:");
            System.out.println("1. " + cuenta1.getTitular());
            System.out.println("2. " + cuenta2.getTitular());
            System.out.println("***********************************************");

            System.out.println("¿Qué operación desea realizar?:");
            System.out.println(" A = Consultar datos de cuenta (incluye Nivel de Lealtad)");
            System.out.println(" B = Retiros");
            System.out.println(" T = Transferencias");
            System.out.print("Ingrese su selección (A, B o T): ");

            String seleccion = scn.nextLine();

            switch (seleccion.toUpperCase()) {

                // VER DATOS DE CUENTAS
                case "A":
                    System.out.print("Seleccione una cuenta (1 o 2): ");
                    if (scn.hasNextInt()) {
                        int cuen = scn.nextInt();
                        switch (cuen) {
                            case 1:
                                System.out.println(cuenta1.getDatosCuenta());
                                break;
                            case 2:
                                System.out.println(cuenta2.getDatosCuenta());
                                break;
                            default:
                                System.out.println("Error: No existe esa cuenta.");
                        }
                    } else {
                        System.out.println("Error: Entrada no válida. Debe ingresar 1 o 2.");
                    }
                    break;

                // RETIRAR MONTOS
                case "B":
                    System.out.print("Seleccione una cuenta para retirar (1 o 2): ");
                    if (scn.hasNextInt()) {
                        int cuen = scn.nextInt();
                        Usuario cuentaRetiro = null;
                        if (cuen == 1) {
                            cuentaRetiro = cuenta1;
                        } else if (cuen == 2) {
                            cuentaRetiro = cuenta2;
                        }

                        if (cuentaRetiro != null) {
                            System.out.print("Retiros - Ingrese el monto a retirar: $");
                            if (scn.hasNextDouble()) {
                                monto = scn.nextDouble();
                                if (Usuario.setRetiros(cuentaRetiro, monto)) {
                                    System.out.println("\n¡Retiro exitoso!");
                                    System.out.println(cuentaRetiro.getDatosCuenta());
                                }
                            } else {
                                System.out.println("Error: Monto no válido.");
                            }
                        } else {
                            System.out.println("Error: Cuenta no válida.");
                        }
                    } else {
                        System.out.println("Error: Entrada no válida. Debe ingresar 1 o 2.");
                    }
                    break;

                // TRANSFERENCIAS
                case "T":
                    System.out.print("Ingrese el monto a transferir: $");
                    if (scn.hasNextDouble()) {
                        monto = scn.nextDouble();
                        // Se asume que la transferencia es de cuenta1 a cuenta2 como en el código original
                        if (Usuario.setTransferencia(cuenta1, cuenta2, monto)) {
                            System.out.println("\n¡Transferencia exitosa!");
                            System.out.println("--- Saldo Actualizado ---");
                            System.out.println(cuenta1.getDatosCuenta());
                            System.out.println(cuenta2.getDatosCuenta());
                        }
                    } else {
                        System.out.println("Error: Monto no válido.");
                    }
                    break;

                default:
                    System.out.println("Error: Operación no reconocida.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
