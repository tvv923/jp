package edu.hillel.lesson16;

public class ValueCalculator {
    private final float[] values;
    private final int size;
    private final int halfSize;

    public ValueCalculator(int size) {
        if (size < 1000000) {
            throw new IllegalArgumentException("Array size mustn't be less then 1000000.");
        }
        this.size = size;
        this.halfSize = size / 2;
        this.values = new float[size];
    }

    public void calculateValues() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            values[i] = 1.0f;
        }

        float[] a1 = new float[halfSize];
        float[] a2 = new float[halfSize];

        System.arraycopy(values, 0, a1, 0, halfSize);
        System.arraycopy(values, halfSize, a2, 0, halfSize);

        Thread thread1 = new Thread(() -> processArray(a1, 0));
        Thread thread2 = new Thread(() -> processArray(a2, halfSize));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Waiting threads completion error.", e);
        }

        System.arraycopy(a1, 0, values, 0, halfSize);
        System.arraycopy(a2, 0, values, halfSize, halfSize);

        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.println("Execution time: " + executionTime + " ms");
    }

    private void processArray(float[] array, int startIndex) {
        for (int i = 0; i < array.length; i++) {
            int index = startIndex + i;
            array[i] = (float)(array[i] * Math.sin(0.2f + index / 5) *
                    Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
        }
    }
}