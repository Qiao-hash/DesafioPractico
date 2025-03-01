public class Alumno {
    String carnet, nombre, apellidos, fechaNacimiento, direccion;

    Alumno(String carnet, String nombre, String apellidos, String fechaNacimiento, String direccion){
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
    @Override
    public String toString() {
        return "Carnet: " + carnet + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", FechaNacimiento: " + fechaNacimiento + ", Direccion: " + direccion;
    }
}

