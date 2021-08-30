package com.nvv.itstep.hw.d29082021;

@Developer
public class ClerkResult extends Thread {
    private boolean isAllDone;
    private int sum;
    private int average;
    private int min;
    private int max;
    private final AccountsClerk accountsClerk;

    public ClerkResult(AccountsClerk accountsClerk) {
        this.accountsClerk = accountsClerk;
    }

    public int getSum() {
        return sum;
    }

    public int getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        isAllDone = false;
        boolean isSumDone = false;
        boolean isAverageDone = false;
        boolean isMinDone = false;
        boolean isMaxDone = false;

        while (!isAllDone) {
            isSumDone = accountsClerk.getIsSumCounting();
            isAverageDone = accountsClerk.getIsAverageCounting();
            isMaxDone = accountsClerk.getIsMaxCounting();
            isMinDone = accountsClerk.getIsMinCounting();

            if (!isAverageDone || !isSumDone || !isMaxDone || !isMinDone) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                sum = accountsClerk.getSum();
                average = accountsClerk.getAverage();
                max = accountsClerk.getMax();
                min = accountsClerk.getMin();
                isAllDone = true;
            }
        }
    }
}

