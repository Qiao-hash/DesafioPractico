import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<Alumno> alumnos = new ArrayList<>();
    private static HashMap<String, Materia> materias = new HashMap<>();
    public static void main(String[] args) {
        while (true){
            String opcion = JOptionPane.showInputDialog(
                    "Menu Principal\n" +
                    "1. Gestionar Alumnos\n" +
                    "2. Gestionar Materias\n" +
                    "3. Salir\n" +
                    "Seleccione una opción:"
            );

            if (opcion == null || opcion.equals("3")) {
                break;
            }
            switch (opcion) {
                case "1":
                    gestionarAlumnos();
                    break;
                case "2":
                    gestionarMaterias();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no Válida.");
            }
        }
    }

    private static void gestionarAlumnos() {
        while (true){
            String op = JOptionPane.showInputDialog(
                    "Gestión de Alumnos\n" +
                    "1. Listar Alumnos:\n" +
                    "2. Registra Alumnos:\n" +
                    "3. Editar Alumnos:\n" +
                    "4. Eliminar Alumno:\n" +
                    "5. Volver\n" +
                    "Selecione una opcion:"
            );
            if (op == null || op.equals("5")) {
                break;
            }
            switch (op) {
                case "1":
                    listarAlumnos();
                    break;
                case "2":
                    registrarAlumnos();
                    break;
                case "3":
                    editarAlumnos();
                    break;
                case "4":
                    eliminarAlumno();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no válida");
            }
        }
    }
    private static void listarAlumnos() {
        if(alumnos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay Alumnos registrados aún.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Alumno alumno : alumnos) {
            sb.append(alumno.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void registrarAlumnos() {
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet del alumno:");
        if (carnet == null) return;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
        if (nombre == null) return;

        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del alumno:");
        if (apellidos == null) return;

        String fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del alumno:");
        if (fechaNacimiento == null) return;

        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del alumno:");
        if (direccion == null) return;

        Alumno nuevoAlumno = new Alumno(carnet, nombre, apellidos, fechaNacimiento, direccion);
        alumnos.add(nuevoAlumno);
        JOptionPane.showMessageDialog(null, "Alumno registrado con éxito.");
    }

    private static void editarAlumnos() {
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet del alumno a editar:");
        if (carnet == null) return;

        Alumno alumno = buscarAlumnoPorCarnet(carnet);

        if (alumno == null) {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
            return;
        }

        // Validar cada campo
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de alumno:", alumno.nombre);
        if (nombre == null) return;

        String apellidos = JOptionPane.showInputDialog("Ingrese los nuevos apellidos del alumno:", alumno.apellidos);
        if (apellidos == null) return;

        String fechaNacimiento = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento:", alumno.fechaNacimiento);
        if (fechaNacimiento == null) return;

        String direccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:", alumno.direccion);
        if (direccion == null) return;

        alumno.nombre = nombre;
        alumno.apellidos = apellidos;
        alumno.fechaNacimiento = fechaNacimiento;
        alumno.direccion = direccion;
        JOptionPane.showMessageDialog(null, "Alumno actualizado con éxito.");
    }


    private static void eliminarAlumno() {
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet del alumno:");

        Alumno alumno = buscarAlumnoPorCarnet(carnet);
        if (alumno != null) {
            alumnos.remove(alumno);
            JOptionPane.showMessageDialog(null, "Alumno Eliminado con Éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
        }
    }

    private static Alumno buscarAlumnoPorCarnet(String carnet) {
        for (Alumno alumno : alumnos) {
            if (alumno.carnet.equals(carnet)) {
                return alumno;
            }
        }
        return null;
    }

    private static void gestionarMaterias() {
        while (true){
            String op = JOptionPane.showInputDialog(
                    "Gestión de Materias\n" +
                    "1. Listar Materias\n" +
                    "2. Registrar Materia\n" +
                    "3. Editar Materia\n" +
                    "4. Eliminar Materia\n" +
                    "5. Volver\n" +
                    "Selecione una opcion:"
            );
            if (op == null || op.equals("5")) {
                break;
            }

            switch (op) {
                case "1":
                    listarMaterias();
                    break;
                case "2":
                    registrarMateria();
                    break;
                case "3":
                    editarMateria();
                    break;
                case "4":
                    eliminarMateria();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
    private static void listarMaterias() {
        if (materias.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay materias registrados");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Materia materia : materias.values()) {
            sb.append(materia.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void registrarMateria() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la materia:");
        if (codigo == null) return;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la materia:");
        if (nombre == null) return;

        String desc = JOptionPane.showInputDialog("Ingrese la descripción de la materia:");
        if (desc == null) return;

        String fechaCreacion = JOptionPane.showInputDialog("Ingrese la fecha de creación de la materia:");
        if (fechaCreacion == null) return;

        Materia nuevaMateria = new Materia(codigo, nombre, desc, fechaCreacion);
        materias.put(codigo, nuevaMateria);
        JOptionPane.showMessageDialog(null, "Materia registrada con éxito.");
    }

    private static void editarMateria() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la materia a editar:");
        if (codigo == null) return; // Cancelar en primera entrada

        Materia materia = materias.get(codigo);

        if (materia == null) {
            JOptionPane.showMessageDialog(null, "Materia no encontrada.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:", materia.nombre);
        if (nombre == null) return;

        String descripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción:", materia.desc);
        if (descripcion == null) return;

        String fechaCreacion = JOptionPane.showInputDialog("Ingrese la nueva fecha:", materia.fechaCreacion);
        if (fechaCreacion == null) return;

        materia.nombre = nombre;
        materia.desc = descripcion;
        materia.fechaCreacion = fechaCreacion;
        JOptionPane.showMessageDialog(null, "Materia actualizada con éxito.");
    }

    private static void eliminarMateria() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código de la materia a eliminar:");
        Materia materia = materias.get(codigo);

        if (materia != null) {
            materias.remove(codigo);
            JOptionPane.showMessageDialog(null, "Materia eliminada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Materia no encontrada.");
        }
    }
}