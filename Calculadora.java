
public class Calculadora {

    public static double calcular(double num1, double num2, String operador) throws ArithmeticException, IllegalArgumentException {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("No se puede dividir por cero.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador no valido.");
        }
    }
}