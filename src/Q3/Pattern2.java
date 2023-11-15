package Q3;

public class Pattern2 implements Runnable {

    private final Object lock;
    private final String pattern;
    private final int count;

    public Pattern2(Object lock, String pattern, int count) {
        this.lock = lock;
        this.pattern = pattern;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Pattern02 Thread = " + pattern);
            }
        }
    }
}

