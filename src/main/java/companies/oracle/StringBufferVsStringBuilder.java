package companies.oracle;

public class StringBufferVsStringBuilder {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        // Create multiple threads to modify the strings concurrently
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("A");
                stringBuilder.append("A");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("B");
                stringBuilder.append("B");
        }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the lengths of the modified strings
        System.out.println("StringBuffer length: " + stringBuffer.length());
        System.out.println("StringBuilder length: " + stringBuilder.length());
    }
}
