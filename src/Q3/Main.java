package Q3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Pattern 1 = ");
        String pattern1 = scanner.nextLine();

        System.out.println("Enter Pattern 2 = ");
        String pattern2 = scanner.nextLine();

        System.out.println("Enter count = ");
        int count = scanner.nextInt();

        Object lock = new Object(); // Create a synchronization lock

        Thread pattern1Thread = new Thread(new Pattern1(lock, pattern1, count));
        Thread pattern2Thread = new Thread(new Pattern2(lock, pattern2, count));

        pattern1Thread.start();
        pattern2Thread.start();

        try {
            pattern1Thread.join();
            pattern2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========Threads end============");

        // Print the inverted triangle patterns
        printInvertedTriangle(pattern1, pattern2, count);
    }

    private static void printInvertedTriangle(String pattern1, String pattern2, int count) {
        for (int i = count; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 1) {
                    System.out.print(pattern1);
                } else {
                    System.out.print(pattern2);
                }
            }
            System.out.println();
        }
    }
}

