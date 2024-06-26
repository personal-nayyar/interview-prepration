package mix;

public class DeadlockExample {
    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Holding lock on resource1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock on resource2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holding lock on resource1 and resource2...");
                }
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Holding lock on resource2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock on resource1...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Holding lock on resource1 and resource2...");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads completed.");
    }
}
