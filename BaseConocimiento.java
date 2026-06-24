import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BaseConocimiento {
    
    private final List<Estudiante> estudiantes;

    public BaseConocimiento() {
        
        this.estudiantes = Arrays.asList(
            new Estudiante("Juan", "Matematicas", 4.5),
            new Estudiante("Maria", "Fisica", 6.0),
            new Estudiante("Pedro", "Quimica", 3.5),
            new Estudiante("Ana", "Biologia", 5.2),
            new Estudiante("Luis", "Historia", 2.8),
            new Estudiante("Carlos", "Lenguaje", 4.0),
            new Estudiante("Laura", "Ingles", 6.5),
            new Estudiante("Sofia", "Matematicas", 5.0),
            new Estudiante("Diego", "Fisica", 3.9),
            new Estudiante("Valeria", "Quimica", 4.8),
            new Estudiante("Javier", "Biologia", 5.5),
            new Estudiante("Camila", "Historia", 6.2),
            new Estudiante("Andres", "Lenguaje", 3.0),
            new Estudiante("Paula", "Ingles", 4.1),
            new Estudiante("Fernando", "Matematicas", 5.8),
            new Estudiante("Daniela", "Fisica", 6.8),
            new Estudiante("Pablo", "Quimica", 2.5),
            new Estudiante("Isabel", "Biologia", 4.4),
            new Estudiante("Martin", "Historia", 5.3),
            new Estudiante("Lucia", "Lenguaje", 6.1),
            new Estudiante("Tomas", "Ingles", 3.7),
            new Estudiante("Catalina", "Matematicas", 4.9),
            new Estudiante("Nicolas", "Fisica", 5.6),
            new Estudiante("Valentina", "Quimica", 6.4),
            new Estudiante("Emilio", "Biologia", 3.2),
            new Estudiante("Florencia", "Historia", 4.7),
            new Estudiante("Rodrigo", "Lenguaje", 5.9),
            new Estudiante("Antonella", "Ingles", 6.7),
            new Estudiante("Ignacio", "Matematicas", 3.8),
            new Estudiante("Martina", "Fisica", 5.1)
        );
    }

    public boolean perteneceACurso(String nombre, String curso) {
        return estudiantes.stream()
                .anyMatch(e -> e.getNombre().equalsIgnoreCase(nombre) && 
                               e.getCurso().equalsIgnoreCase(curso));
    }


    public boolean estaAprobado(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.getNota() >= 4.0);
    }

  
    public boolean estaReprobado(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.getNota() < 4.0);
    }


    public Optional<Estudiante> buscarEstudiante(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}