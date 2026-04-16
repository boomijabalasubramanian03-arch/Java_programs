import java.util.*;
import java.util.Scanner;

public class MultiplicationTableThread implements Runnable {
    private int number;

    public MultiplicationTableThread(int number) {
        this.number = number;
    }

    @Override
    synchronized public void run()
    {
        /*System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++)
            System.out.println(number + " x " + i + " = " + (number * i));*/
            try
            {
                // Introduce a small delay to make the output more readable
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        //System.out.println("------------------------------------");
    }
    public void display(int n)
    {
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++)
            System.out.println(number + " x " + i + " = " + (number * i));
        System.out.println("------------------------------------");

    }

    public static void main(String[] args) {
        int n1,n2,n3;
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE FIRST NUMBER:");
        n1 = sc.nextInt();
        System.out.println("ENTER THE SECOND NUMBER:");
        n2 = sc.nextInt();
        System.out.println("ENTER THE THIRD NUMBER:");
        n3 = sc.nextInt();
        // Create three instances of the Runnable class with different numbers
        MultiplicationTableThread table1 = new MultiplicationTableThread(n1);
        MultiplicationTableThread table2 = new MultiplicationTableThread(n2);
        MultiplicationTableThread table3 = new MultiplicationTableThread(n3);
        // Create three threads, each running a different instance
        Thread thread1 = new Thread(table1);
        Thread thread2 = new Thread(table2);
        Thread thread3 = new Thread(table3);

        table1.display(n1);
        table2.display(n2);
        table3.display(n3);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
