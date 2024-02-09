public class Alumno {
    private String nombre;
    private String apellido1;
    private  String apellido2;
    private String telefono;
    private String correo;
    private int id;
    private double nota1;
    private double nota2;
    private double nota3;
    private double asistencia;
    private double notaTotal;
    private double finales;
    private String notaCualitativa;

    public Alumno(String nombre, String apellido1, String apellido2, String telefono, String correo, double nota1, double nota2, double nota3, double asistencia, double finales) {
        this.id = 0;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.asistencia = asistencia;
        this.finales = finales;
        notaTotal();
        calcularNotaCualitativa();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
        notaTotal();
        calcularNotaCualitativa();
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
        notaTotal();
        calcularNotaCualitativa();
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
        notaTotal();
        calcularNotaCualitativa();
    }

    public double getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(double asistencia) {
        this.asistencia = asistencia;
        notaTotal();
        calcularNotaCualitativa();
    }

    public double getNotaTotal() {
        return notaTotal;
    }

    public double getFinales() {
        return finales;
    }

    public void setFinales(double finales) {
        this.finales = finales;
        notaTotal();
        calcularNotaCualitativa();
    }

    public String getNotaCualitativa() {
        return notaCualitativa;
    }

    public void setNotaCualitativa(String notaCualitativa) {
        this.notaCualitativa = notaCualitativa;
    }

    public void notaTotal(){
        this.notaTotal = (getNota1() * 0.2) + (getNota2() * 0.2) + (getNota3() * 0.2) + (getAsistencia() *0.1) + (getFinales() * 0.3);
    }

    public void calcularNotaCualitativa(){
        if (this.getNotaTotal() >= 5 && this.getNotaTotal() <= 7){
            this.setNotaCualitativa("Aprobado");
        } else if (this.getNotaTotal() >= 8 && this.getNotaTotal() <= 9){
            this.setNotaCualitativa("Notable");
        } else if (this.getNotaTotal() == 10) {
            this.setNotaCualitativa("Sobresaliente");
        } else {
            this.setNotaCualitativa("Suspenso");
        }
    }

    public String toStr() {
        return String.format("%-5d %-12s %-15s %-15s %-14s %-34s %-9.2f %-9.2f %-11.2f %-12.2f %-12.2f %-17.2f %s",
                getId(), getNombre(), getApellido1(), getApellido2(), getTelefono(), getCorreo(), getNota1(),
                getNota2(), getNota3(), getAsistencia(), getFinales(), getNotaTotal(), getNotaCualitativa());
    }
}
