public class Principal {

    public static void main(String[] args) {

        // Creamos una instancia de Persona usando el constructor por defecto y setters
        Persona persona1 = new Persona();
        persona1.setNombre("Linda");
        persona1.setApellidoPaterno("Gómez");
        persona1.setApellidoMaterno("Pérez");
        persona1.setSexo('F'); // Corregido a 'F' para Femenino
        persona1.setEdad(28);
        persona1.setDireccion("Calle Ariban, Madrid");

        // Creamos una segunda instancia de Persona usando el constructor común
        Persona persona2 = new Persona("Clark", "Kent", "SinApellido", 'M', 15, "Smallville, Kansas");

        System.out.println("***********************************************");
        System.out.println("          DEMOSTRACIÓN DE CLASE PERSONA");
        System.out.println("***********************************************");

        // Usamos el método toString() mejorado para imprimir los datos
        System.out.println("\n--- Persona 1 ---");
        System.out.println(persona1); // Llama implícitamente a persona1.toString()

        System.out.println("\n--- Persona 2 ---");
        System.out.println(persona2); // Llama implícitamente a persona2.toString()

        // Demostración del constructor de copia
        Persona persona3 = new Persona(persona1);
        persona3.setNombre("Linda (Copia)");
        System.out.println("\n--- Persona 3 (Copia de Persona 1) ---");
        System.out.println(persona3);
    }
}
