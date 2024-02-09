import java.util.ArrayList;

public class GestorAlumno {
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    private int id = 1;
    public void agregarAlumno(Alumno alumno){
        alumno.setId(id++);
        alumnos.add(alumno);
    }

    public ArrayList<Alumno> listadoAlumnos(){
        return alumnos;
    }

    //Metodo Eliminar a un alumno por el ID
    public void eliminarAlumno(int id){
        ArrayList<Alumno> eliminar = new ArrayList<Alumno>(); //se declara un nuevo ArrayList
        for (Alumno a : alumnos){
            if (a.getId() == id){
                eliminar.add(a); //con el bucle for recorremos el array alumnos y si cumple la condicion se agregar al nuevo array
            }
        } alumnos.removeAll(eliminar); // luego se elimina del array principal
    }

    public ArrayList<Alumno> buscarAlumno(int id){
        ArrayList<Alumno> buscar = new ArrayList<Alumno>();
        for (Alumno a : alumnos){
            if (id == a.getId()){
                buscar.add(a);
            }
        } return buscar;
    }
}
