package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Strategy;

public class Developer {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    
    public void executeActivity() {
        activity.justDoIt();
    }
}
