package com.nvv.itstep.lection.l11_enum;

public class Main1 {
    public static void main(String[] args) {
        //
        TrafficLight trafficLight = new TrafficLight(ColorEnum.RED);
        trafficLight.setColor(ColorEnum.YELLOW);
        trafficLight.setColor(ColorEnum.GREEN);
        trafficLight.setColor(ColorEnum.RED);


        if (trafficLight.getColor() == ColorEnum.RED) {
            System.out.println("stop");
        }


//        ColorEnum colorEnum = ColorEnum.GREEN;
//        System.out.println(colorEnum.ordinal());

//        for (ColorEnum value : ColorEnum.values()) {
//
//        }

//        System.out.println(trafficLight.getColor().getHex());
//        System.out.println(trafficLight.getColor().getHex());
//        trafficLight.getColor().setHex();
        System.out.println(trafficLight.getColor().hex);
        System.out.println(trafficLight.getColor().hex);

        System.out.println("❤");
    }
}
