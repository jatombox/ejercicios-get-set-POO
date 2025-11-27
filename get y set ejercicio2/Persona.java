public class Persona {

    // Attributes
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private char sexo; // 'M' for Masculino, 'F' for Femenino, 'O' for Otro
    private int edad;
    private String direccion;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor de copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellidoPaterno = persona.apellidoPaterno;
        this.apellidoMaterno = persona.apellidoMaterno;
        this.sexo = persona.sexo;
        this.edad = persona.edad;
        this.direccion = persona.direccion;
    }

    // Constructor común
    public Persona(String nom, String app, String apm, char sexo, int edad, String dir) {
        this.nombre = nom;
        this.apellidoPaterno = app;
        this.apellidoMaterno = apm;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = dir;
    }

    // Método para verificar si es mayor de edad (mejorado)
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    // Método para mostrar datos (reemplazado por toString)
    @Override
    public String toString() {
        return "--- Datos Personales ---\n" +
               "Nombre Completo: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + "\n" +
               "Sexo: " + sexo + "\n" +
               "Edad: " + edad + " (" + (esMayorDeEdad() ? "Mayor de Edad" : "Menor de Edad") + ")\n" +
               "Dirección: " + direccion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
