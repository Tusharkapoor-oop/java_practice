/* Design and implement a multithreaded Java program that performs different numerical tasks 
concurrently using multiple threads. 
The program should: 
1. Create three separate threads, each performing a distinct task: 
o Thread 1: Prints even numbers from 1 to 20. 
o Thread 2: Prints odd numbers from 1 to 20. 
o Thread 3: Calculates and displays the sum of numbers from 1 to 20.
*/

class EvenThread extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) System.out.println("Even: " + i);
        }
    }
}
class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) System.out.println("Odd: " + i);
        }
    }
}
class SumThread implements Runnable {
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 20; i++) sum += i;
        System.out.println("Sum: " + sum);
    }
}
public class MultithreadedTasks {
    public static void main(String[] args) {
        EvenThread e = new EvenThread();
        OddThread o = new OddThread();
        Thread s = new Thread(new SumThread());

        o.start();
        e.start();
        s.start();
    }
}



