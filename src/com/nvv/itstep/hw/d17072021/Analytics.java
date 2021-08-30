package com.nvv.itstep.hw.d17072021;



public class Analytics {
    public static int AverageAge(ArrayUser data) {
        int result = 0;
        if (data != null && data.size() != 0) {
            for (int i = 0; i < data.size(); i++) {
                result += data.get(i).getAge();
            }
        }
        if(result!=0){
            result /= data.size();
        }
        return result;
    }
}
