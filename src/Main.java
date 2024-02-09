import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner scannerStr = new Scanner(System.in);
    public static Scanner scannerNum = new Scanner(System.in).useLocale(Locale.US);

    static ArrayList<Alumno> a = new ArrayList<Alumno>();

    public static void main(String[] args) {
        GestorAlumno ga = new GestorAlumno();
        boolean salir = false;
        int opcion;
        do {
            menu();
            System.out.print("Elija una opcion: ");
            opcion = scannerNum.nextInt();
            switch (opcion) {
                case 1:
                    ingresarAlumno(ga);
                    break;
                case 2:
                    mostrarAlumno(ga);
                    break;
                case 3:
                    modificarAlumno(ga);
                    break;
                case 4:
                    mocearAlumnos(ga);
                    break;
                case 9:
                    eliminadoDeAlumno(ga);
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
        System.out.println("Fin del programa");
    }

    private static void menu() {
        System.out.println("\n==============================================");
        System.out.println("   Bienvanido al registro de datos de ILerna");
        System.out.println("==============================================");
        System.out.println("               Menu de Opciones               ");
        System.out.println("==============================================");
        System.out.println("1. Ingresar datos del alumno");
        System.out.println("2. Listar registro de alumnos");
        System.out.println("3. Actualizar/Modificar lista");
        System.out.println("4. Agregar grupo de alumnos");
        System.out.println("9. Eliminar registro de alumno");
        System.out.println("0. Salir");
    }

    //Metodo de ingresar datos de un alumno
    private static void ingresarAlumno(GestorAlumno ga) {
        String nombre;
        String apellido1;
        String apellido2;
        String telefono;
        String correo;
        double nota1;
        double nota2;
        double nota3;
        double asistencia;
        double finales;

        // Ingreso de datos
        System.out.println("======================================\n");
        System.out.println("   Ingreso de datos sobre el alumno   ");
        System.out.println("======================================\n");
        System.out.print("Nombre: ");
        nombre = scannerStr.nextLine();
        System.out.print("Primer Apellido: ");
        apellido1 = scannerStr.nextLine();
        System.out.print("Segundo Apellido: ");
        apellido2 = scannerStr.nextLine();
        System.out.print("Telefono: ");
        telefono = scannerStr.nextLine();
        System.out.print("Correo electronico: ");
        correo = scannerStr.nextLine();
        System.out.print("Nota 1: ");
        nota1 = scannerNum.nextDouble();
        System.out.print("Nota 2: ");
        nota2 = scannerNum.nextDouble();
        System.out.print("Nota 3: ");
        nota3 = scannerNum.nextDouble();
        System.out.print("Asistencia: ");
        asistencia = scannerNum.nextDouble();
        System.out.print("Finales: ");
        finales = scannerNum.nextDouble();
        System.out.printf("%s %s %s fue añadido con exito", nombre, apellido1, apellido2);
        //Agregar al ArrayList
        ga.agregarAlumno(new Alumno(nombre, apellido1, apellido2, telefono, correo, nota1, nota2, nota3, asistencia, finales));
    }

    private static void cabeceraListado() {
        System.out.println("                                                                                         Registro de alumnos                                                                                ");
        System.out.println("============================================================================================================================================================================================");
        System.out.println("ID    Nombre       Apellido1       Apellido2       Telefono       Correo electronico                 Nota1     Nota2     Nota3     Asistencia    Finales    Nota total      Nota Cualitativa");
        System.out.println("============================================================================================================================================================================================");
    }

    private static void mostrarAlumno(GestorAlumno ga) {
        cabeceraListado();
        for (Alumno a : ga.listadoAlumnos()) {
            System.out.println(a.toStr());
        }
        System.out.println("============================================================================================================================================================================================");
    }

    private static void mocearAlumnos(GestorAlumno ga) {
        ga.agregarAlumno(new Alumno("Luis", "Figuereo", "Ali", "123456789", "luisfiguereo@gmail.com", 7, 8, 10, 5, 5));
        ga.agregarAlumno(new Alumno("Victoria", "Leon", "Algo", "321654987", "victorialeon@gmail.com", 9, 8, 7, 4, 10));
        ga.agregarAlumno(new Alumno("Laurent", "Henriquez", "Algo2", "245781453", "laurenthenriquez@gmail.com", 7, 8, 10, 3, 9));
        ga.agregarAlumno(new Alumno("Ruben", "Mendoza", "zxcas", "254865936", "rubenmendoza@gmail.com", 3, 9, 5, 7, 9));
        ga.agregarAlumno(new Alumno("Yendi", "Jael", "acsvczxc", "258946357", "yendijael@gmail.com", 8, 7, 10, 8, 6));
        ga.agregarAlumno(new Alumno("Juan", "Herrea", "fvljzxcnxz", "254698746", "juanherrera@gmail.com", 4.3, 9, 3.5, 4, 5.5));
        ga.agregarAlumno(new Alumno("Vitaliy", "Ali", "asfgfdgbcxv", "213589745", "vitaliyali@gmail.com", 9, 10, 8, 7, 10));
        ga.agregarAlumno(new Alumno("Gabriela", "Beltramino", "fdhjkljnb", "326598147", "gabrielabeltramino@gmail.com", 7, 5, 9, 6, 8));
        ga.agregarAlumno(new Alumno("Fernando", "Perez", "dasdgfvxcd", "256314856", "fernandoperez@gmail.com", 4.99, 5, 6.7, 8, 4.8));
        System.out.println();
        System.out.println("¡Registros agregados con exito....!");
    }

    private static void eliminadoDeAlumno(GestorAlumno ga) {
        mostrarAlumno(ga);
        System.out.print("Ingrese el ID de la persona que desea eliminar: ");
        int id = scannerStr.nextInt();
        ga.eliminarAlumno(id);
    }

    private static void modificarAlumno(GestorAlumno ga) {
        mostrarAlumno(ga);
        int id;
        System.out.print("Ingrese el ID del alumno que desea modificar: ");
        id = scannerNum.nextInt();
        ga.buscarAlumno(id);
        Alumno alumnoAModificar = ga.buscarAlumno(id).get(0);

        System.out.println("¿Qué desea modificar?");
        int opcion;
        System.out.println("1. Nombre");
        System.out.println("2. Primer Apellido");
        System.out.println("3. Segundo Apellido");
        System.out.println("4. Telefono");
        System.out.println("5. Correo electronico");
        System.out.println("6. Nota 1");
        System.out.println("7. Nota 2");
        System.out.println("8. Nota 3");
        System.out.println("9. Asistencia");
        System.out.println("10. Finales");
        System.out.print("Elija una opcion: ");
        opcion = scannerNum.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scannerStr.next();
                alumnoAModificar.setNombre(nuevoNombre);
                break;
            case 2:
                System.out.print("Ingrese el nuevo primer apellido: ");
                String nuevoApellido1 = scannerStr.next();
                alumnoAModificar.setApellido1(nuevoApellido1);
                break;
            case 3:
                System.out.print("Ingrese el nuevo segundo apellido: ");
                String nuevoSegundoApellido = scannerStr.next();
                alumnoAModificar.setApellido2(nuevoSegundoApellido);
                break;
            case 4:
                System.out.print("Ingrese el nuevo telefono: ");
                String nuevoTelefono = scannerStr.next();
                alumnoAModificar.setTelefono(nuevoTelefono);
                break;
            case 5:
                System.out.print("Ingrese el nuevo correo electronico: ");
                String nuevoCorreo = scannerStr.next();
                alumnoAModificar.setCorreo(nuevoCorreo);
                break;
            case 6:
                System.out.print("Ingrese la nueva Nota 1: ");
                double nuevaNota1 = scannerNum.nextDouble();
                alumnoAModificar.setNota1(nuevaNota1);
                break;
            case 7:
                System.out.print("Ingrese la nueva Nota 2: ");
                double nuevaNota2 = scannerNum.nextDouble();
                alumnoAModificar.setNota2(nuevaNota2);
                break;
            case 8:
                System.out.print("Ingrese la nueva Nota 3: ");
                double nuevaNota3 = scannerNum.nextDouble();
                alumnoAModificar.setNota3(nuevaNota3);
                break;
            case 9:
                System.out.print("Ingrese la nueva Asistencia: ");
                int nuevaAsistencia = scannerNum.nextInt();
                alumnoAModificar.setAsistencia(nuevaAsistencia);
                break;
            case 10:
                System.out.print("Ingrese los nuevos Finales: ");
                int nuevosFinales = scannerNum.nextInt();
                alumnoAModificar.setFinales(nuevosFinales);
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
}