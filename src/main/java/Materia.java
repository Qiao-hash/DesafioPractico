public class Materia{
    String codigo, nombre, desc, fechaCreacion;

    Materia(String codigo, String nombre, String desc, String fechaCreacion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.desc = desc;
        this.fechaCreacion = fechaCreacion;
    }
    @Override
    public String toString(){
        return "Código: " + codigo + ", Nombre: " + nombre + ", Desc: " + desc + ", Fecha: " + fechaCreacion;
    }
}


