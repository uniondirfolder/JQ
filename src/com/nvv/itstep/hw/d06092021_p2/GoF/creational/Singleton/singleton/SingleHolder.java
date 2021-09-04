package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Singleton.singleton;

public class SingleHolder {
    private SingleHolder() {}

    private static class Holder {
        private static SingleHolder instance = new SingleHolder();
    }

    public static SingleHolder getInstance() {
        return Holder.instance;
    }
}
