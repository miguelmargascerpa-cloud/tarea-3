import java.util.Optional;
import java.util.Scanner;


public class CentroApoyo {

    private final BaseConocimiento base;
    private final Scanner scanner;

    public CentroApoyo() {
        this.base = new BaseConocimiento();
        this.scanner = new Scanner(System.in);
    }


    private void realizarConsultaInteractiva() {
        System.out.print("Ingrese el nombre del estudiante a consultar: ");
        String nombre = scanner.nextLine().trim();

        Optional<Estudiante> estudianteOpt = base.buscarEstudiante(nombre);

        estudianteOpt.ifPresentOrElse(
            e -> {
                System.out.println("--- Resultados para " + e.getNombre() + " ---");
                System.out.println("Nota obtenida: " + e.getNota());
                
                // Uso de los métodos solicitados en la rúbrica
                if (base.estaAprobado(nombre)) {
                    System.out.println("Estado: APROBADO");
                } else if (base.estaReprobado(nombre)) {
                    System.out.println("Estado: REPROBADO");
                }
            },
            () -> System.out.println("Error: El estudiante ingresado no se encuentra en el sistema.")
        );
    }


    private void iniciarCalculadora() {
        try {
            System.out.print("Ingrese el primer numero: ");
            double n1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese el segundo numero: ");
            double n2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la operacion (+, -, *, /): ");
            String op = scanner.nextLine().trim();

            double resultado = Calculadora.calcular(n1, n2, op);
            System.out.println("-> El resultado es: " + resultado);

        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar numeros validos.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n=======================================");
            System.out.println("   CENTRO DE APOYO ACADEMICO           ");
            System.out.println("=======================================");
            System.out.println("1. Consultar estado de un estudiante");
            System.out.println("2. Verificar si pertenece a un curso");
            System.out.println("3. Usar calculadora basica");
            System.out.println("4. Salir del sistema");
            System.out.println("=======================================");
            System.out.print("Seleccione una opcion (1-4): ");
            
            opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    realizarConsultaInteractiva();
                    break;
                case "2":
                    System.out.print("Nombre del estudiante: ");
                    String nom = scanner.nextLine();
                    System.out.print("Nombre del curso: ");
                    String cur = scanner.nextLine();
                    boolean pertenece = base.perteneceACurso(nom, cur);
                    System.out.println(pertenece ? "-> El estudiante SI pertenece al curso." : "-> El estudiante NO pertenece al curso.");
                    break;
                case "3":
                    iniciarCalculadora();
                    break;
                case "4":
                    System.out.println("Cerrando el sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente con un numero del 1 al 4.");
            }
        } while (!opcion.equals("4"));
    }

    public static void main(String[] args) {
        CentroApoyo app = new CentroApoyo();
        app.mostrarMenu();
    }
}