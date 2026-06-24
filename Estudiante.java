public class Estudiante {
    private String nombre;
    private String curso;
    private double nota;

    public Estudiante(String nombre, String curso, double nota) {
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public double getNota() {
        return nota;
    }
}