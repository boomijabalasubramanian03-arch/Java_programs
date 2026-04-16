import java.util.Scanner;

public class LambdaCalculator {

    // Functional interface for arithmetic operations
    interface ArithmeticOperation {
        double operate(double a, double b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lambda expressions for arithmetic operations
        ArithmeticOperation add = (a, b) -> a + b;
        ArithmeticOperation subtract = (a, b) -> a - b;
        ArithmeticOperation multiply = (a, b) -> a * b;
        ArithmeticOperation divide = (a, b) -> {
            if (b == 0) {
                System.out.println("Error: Division by zero");
                return Double.NaN;
            }
            return a / b;
        };

        System.out.println("Simple Arithmetic Calculator");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Choose operation (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        double result;

        switch (op) {
            case '+':
                result = add.operate(num1, num2);
                break;
            case '-':
                result = subtract.operate(num1, num2);
                break;
            case '*':
                result = multiply.operate(num1, num2);
                break;
            case '/':
                result = divide.operate(num1, num2);
                break;
            default:
                System.out.println("Invalid operation");
                scanner.close();
                return;
        }

        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
