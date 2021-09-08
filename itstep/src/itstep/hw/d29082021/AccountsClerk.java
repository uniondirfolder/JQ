package itstep.hw.d29082021;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

@Developer
public class AccountsClerk {
    private AtomicIntegerArray array;

    private final AtomicBoolean isFilling = new AtomicBoolean(Boolean.FALSE);
    private final AtomicBoolean isAverageCounting = new AtomicBoolean(Boolean.FALSE);
    private final AtomicBoolean isSumCounting = new AtomicBoolean(Boolean.FALSE);
    private final AtomicBoolean isMinCounting = new AtomicBoolean(Boolean.FALSE);
    private final AtomicBoolean isMaxCounting = new AtomicBoolean(Boolean.FALSE);

    private final AtomicInteger average = new AtomicInteger(0);
    private final AtomicInteger sum = new AtomicInteger(0);
    private final AtomicInteger min = new AtomicInteger(0);
    private final AtomicInteger max = new AtomicInteger(0);

    private final ArrayList logBuffer = new ArrayList();
    private final long time = new Date().getTime();

    private Random random;
    private int size;

    public synchronized String getArray() {
        return array.toString();
    }

    public synchronized boolean getIsAverageCounting() {
        logBuffer.add("ask -> id:" + Thread.currentThread().getId() + " | time " + (new Date().getTime() - time));
        return isAverageCounting.get();
    }

    public synchronized boolean getIsSumCounting() {
        logBuffer.add("ask -> id:" + Thread.currentThread().getId() + " | time " + (new Date().getTime() - time));
        return isSumCounting.get();
    }

    public synchronized boolean getIsMinCounting() {
        return isMinCounting.get();
    }

    public synchronized boolean getIsMaxCounting() {
        return isMaxCounting.get();
    }

    public synchronized int getAverage() {
        return average.get();
    }

    public synchronized int getSum() {
        return sum.get();
    }

    public synchronized int getMin() {
        return min.get();
    }

    public synchronized int getMax() {
        return max.get();
    }

    public synchronized ArrayList<String> getLogBuffer() {
        return logBuffer;
    }

    public AccountsClerk(Integer[] array) {
        new Fill(array).start();
        new Average().start();
        new Sum().start();
        new Max().start();
        new Min().start();
    }

    public AccountsClerk(Random random, int size) {
        this.random = random;
        this.size = size;

        new Fill(random).start();
        new Average().start();
        new Sum().start();
        new Max().start();
        new Min().start();
    }


    class Average extends Thread {
        public Average() {
            super("average");
        }

        @Override
        public void run() {
            super.run();
            if (array != null) {
                while (true) {
                    if (!isFilling.get()) {
                        try {
                            Thread.sleep(2);
                            logBuffer.add(Thread.currentThread().getName() + " wait " + Thread.currentThread().getId() + " | time - " + (new Date().getTime() - time));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        logBuffer.add(Thread.currentThread().getName()  + " start task " + " | time - " + (new Date().getTime() - time));
                        break;
                    }
                }
                isAverageCounting.set(Boolean.FALSE);
                average.set(0);

                for (int i = 0, j = 0; i < array.length(); i++) {
                    average.set(average.get() + array.get(i));
                }
                average.set(average.get() / array.length());
                logBuffer.add(Thread.currentThread().getName() + " end task " + " | time - " + (new Date().getTime() - time));
                isAverageCounting.set(Boolean.TRUE);
            }
        }
    }

    class Sum extends Thread {
        public Sum() {
            super("sum");
        }

        @Override
        public void run() {
            super.run();
            if (array != null) {
                while (true) {
                    if (!isFilling.get()) {
                        try {
                            Thread.sleep(2);
                            logBuffer.add(Thread.currentThread().getName() + " wait " + Thread.currentThread().getId() + " | time - " + (new Date().getTime() - time));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        logBuffer.add(Thread.currentThread().getName()  + " start task " + " | time - " + (new Date().getTime() - time));
                        break;
                    }
                }
                isSumCounting.set(Boolean.FALSE);
                sum.set(0);
                for (int i = 0; i < array.length(); i++) {
                    sum.set(sum.get() + array.get(i));
                }
                logBuffer.add(Thread.currentThread().getName() + " end task " + " | time - " + (new Date().getTime() - time));
                isSumCounting.set(Boolean.TRUE);
            }
        }
    }

    class Min extends Thread {
        public Min() {
            super("min");
        }

        @Override
        public void run() {
            super.run();
            if (array != null) {
                while (true) {
                    if (!isFilling.get()) {
                        try {
                            Thread.sleep(2);
                            logBuffer.add(Thread.currentThread().getName() + " wait " + Thread.currentThread().getId() + " | time - " + (new Date().getTime() - time));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        logBuffer.add(Thread.currentThread().getName()  + " start task " + " | time - " + (new Date().getTime() - time));
                        break;
                    }
                }
                isMinCounting.set(Boolean.FALSE);
                min.set(Integer.MAX_VALUE);
                for (int i = 0, j = 0; i < array.length(); i++) {
                    j = array.get(i);
                    if (j < min.get()) {
                        min.set(j);
                    }
                }
                logBuffer.add(Thread.currentThread().getName() + " end task " + " | time - " + (new Date().getTime() - time));
                isMinCounting.set(Boolean.TRUE);
            }
        }
    }

    class Max extends Thread {
        public Max() {
            super("max");
        }

        @Override
        public void run() {
            super.run();
            if (array != null) {
                while (true) {
                    if (!isFilling.get()) {
                        try {
                            Thread.sleep(2);
                            logBuffer.add(Thread.currentThread().getName() + " wait " + Thread.currentThread().getId() + " | time - " + (new Date().getTime() - time));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        logBuffer.add(Thread.currentThread().getName()  + " start task " + " | time - " + (new Date().getTime() - time));
                        break;
                    }
                }
                isMaxCounting.set(Boolean.FALSE);
                max.set(Integer.MIN_VALUE);
                for (int i = 0, j = 0; i < array.length(); i++) {
                    j = array.get(i);
                    if (j > max.get()) {
                        max.set(j);
                    }
                }
                logBuffer.add(Thread.currentThread().getName() + " end task " + " | time - " + (new Date().getTime() - time));
                isMaxCounting.set(Boolean.TRUE);
            }
        }
    }

    class Fill extends Thread {
        private Integer[] arrayI;
        private Random randomI;

        public Fill(Integer[] arrayI) {
            super("fill");
            this.arrayI = arrayI;
        }

        public Fill(Random randomI) {
            super("fill");
            this.randomI = randomI;
        }

        @Override
        public void run() {
            super.run();
            isFilling.set(Boolean.FALSE);
            if (size > 0) {
                array = new AtomicIntegerArray(size);
            } else if (arrayI != null) {
                array = new AtomicIntegerArray(arrayI.length);
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logBuffer.add(Thread.currentThread().getName()  + " start task " + " | time - " + (new Date().getTime() - time));

            if (size > 0 && random != null) {
                for (int i = 0; i < size; i++) {
                    array.set(i, random.nextInt(1000));
                }
            } else if (arrayI != null) {
                for (int i = 0; i < arrayI.length; i++) {
                    array.set(i, arrayI[i]);
                }
            } else {
                array = new AtomicIntegerArray(1);
                array.set(0, 0);
            }

            logBuffer.add(Thread.currentThread().getName() + " end task " + " | time - " + (new Date().getTime() - time));
            isFilling.set(Boolean.TRUE);

        }
    }

}