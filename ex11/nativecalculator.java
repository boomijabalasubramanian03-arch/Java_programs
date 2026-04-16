import java.util.*;
public class NativeCalculator {
    // Declare native methods for arithmetic operations
    public native int add(int a, int b);
    public native int subtract(int a, int b);
    public native int multiply(int a, int b);
    public native double divide(int a, int b);

    // Load the native library
    static {
        System.loadLibrary("calculator"); // The name of your C library
    }

    public static void main(String[] args) {
        NativeCalculator calculator = new NativeCalculator();
        int num1 = 10;
        int num2 = 5;

        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
        System.out.println("Division: " + calculator.divide(num1, num2));
    }
}
